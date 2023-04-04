import argparse

import pandas as pd
import numpy as np

import tensorflow as tf

import os
# import time

def rename_df(df):
    rename_dict = {
        'senior_id' : 'userID',
        'lecture_id' : 'classID',
        'education' : '교육',
        'hobby' : '취미',
        'health' : '건강',
        'social' : '친목'
    }

    df.rename(columns=rename_dict,
          inplace=True)

def preprocess_data_by_user(user, df):  
  context = ['age', 'gender', 'physical_disable', 'mental_disable', 'Exercise',
        'Arts&Crafts', 'Cooking', 'Technology', 'Culture', 'History',
        'Language', 'Communication', 'Finance', 'Music']
  features = ['교육', '취미', '건강', '친목']
  test = df.drop_duplicates(subset = ["classID"]).copy()
  test[["userID"]+context] = test[test['userID']==user][["userID"]+context].iloc[0]
  taken_class = df['classID'][df['userID'] == user].tolist()
  test = test[~test['classID'].isin(taken_class)]
  test.drop(columns=['rating'], axis=1, inplace=True)

  return test


def predict_by_user(model, user, n_pick, test):
  context = ['age', 'gender', 'physical_disable', 'mental_disable', 'Exercise',
        'Arts&Crafts', 'Cooking', 'Technology', 'Culture', 'History',
        'Language', 'Communication', 'Finance', 'Music']
  features = ['교육', '취미', '건강', '친목']
  
  output_data = list()
  for feature, user_id, class_id, contex in zip(test[features].astype(np.float32).to_numpy(), test["userID"].astype(np.float32).to_numpy(), test["classID"].astype(np.float32).to_numpy(), test[context].astype(np.float32).to_numpy()):
      model.set_tensor(input_details[0]['index'], feature.reshape(1, -1))
      model.set_tensor(input_details[1]['index'], user_id.reshape(1, -1))
      model.set_tensor(input_details[2]['index'], class_id.reshape(1, -1))
      model.set_tensor(input_details[3]['index'], contex.reshape(1, -1))

      model.invoke()

      output_data.append(model.get_tensor(output_details[0]['index']))

  test["preds"] = output_data
  return test.sort_values(by=["preds"], ascending = False)['classID'].values[:n_pick]


if __name__ == '__main__':
    # start = time.time()

    parser = argparse.ArgumentParser()
    parser.add_argument('--model_path', type=str, default='.\\')
    parser.add_argument('--data_path', type=str, default='.\\')
    parser.add_argument('--predicts_path', type=str, default='.\\')
    parser.add_argument('--user', type=int)
    parser.add_argument('--n_pick', type=int, default=5)

    args = parser.parse_args()
    

    model_path = args.model_path
    model = tf.lite.Interpreter(model_path=os.path.join(model_path, 'recommender.tflite'))
    model.allocate_tensors()

    input_details = model.get_input_details()
    output_details = model.get_output_details()

    data_path = args.data_path
    user = args.user

    user_class_data = pd.read_json(os.path.join(data_path, 'recommender_dataset.json'), encoding='euc-kr')
    rename_df(user_class_data)
    inference_data = preprocess_data_by_user(user, user_class_data)


    n_pick = args.n_pick

    predicts = predict_by_user(model, user, n_pick, inference_data)
    

    predicts_path = args.predicts_path
    
    f = open(os.path.join(predicts_path, f'{user}_class_recommend.txt'), 'w')
    for predict in predicts:
        f.write(str(predict)+'\n')
    f.close()

    # end = time.time()
    # print(f"{end - start:.5f} sec")