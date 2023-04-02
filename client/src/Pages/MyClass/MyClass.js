import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import * as style from "./styles";
import Header from "../../Components/Header/Header";
import Footer from "../../Components/Footer/Footer";
import Dropdown from "../../Components/Dropdown/Dropdown";
import ClassCard from "../../Components/ClassCard/ClassCard";
import FloatingButton from "../../Components/Button/FloatingButton";
import YellowFullButton from "../../Components/Button/YellowFullButton";

export default function MyClass() {
  const title = "내 수업";
  const identity = sessionStorage.getItem("identity");
  const userId = sessionStorage.getItem("userId");
  const navigate = useNavigate();
  const [adata, setData] = useState([]);

  const stateOptions = [
    {
      id: 1,
      label: "진행중인 수업",
    },
    {
      id: 2,
      label: "진행완료 수업",
    },
  ];
  useEffect(() => {
    const url = `http://104.154.76.168:8080/tutor-lecture/my-lecture?tutorId=1&state=registered`;
    axios
      .get(url)
      .then((response) => {
        setData(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);
  const objArray = adata?.map((item) => ({
    key: item.lectureId,
    src: item.imageUrl,
    className: item.title,
    classDays: item.monday,
    classTime: item.activityTime,
    classExplain: item.lectureIntro,
    distance: item.distance,
    location: item.location,
    starCount: item.likeCount,
    registerCount: `${item.presentPeople}/${item.maxPeople}`,
  }));
  const obj = {
    data: objArray,
  };
  return (
    <div>
      <Header title={title} />
      <style.Wrap>
        {identity != 0 && <FloatingButton />}
        <Dropdown
          width={"280px"}
          options={stateOptions}
          placeholder={"진행중인 수업"}
        />
        {obj.data.map((item) => {
          return (
            <div>
              <ClassCard
                key={item.key}
                src={item.src}
                className={item.className}
                classDays={item.classDays}
                classTime={item.classTime}
                classExplain={item.classExplain}
                location={item.location}
                starCount={item.starCount}
                registerCount={item.registerCount}
              />
              <style.ButtonBlock>
                <YellowFullButton
                  width={"170px"}
                  btnName={"수강생 목록 보기"}
                  onClick={() => {
                    navigate("../studentList", {
                      state: {
                        key: item.key,
                        className: item.className,
                      },
                    });
                  }}
                />
              </style.ButtonBlock>
            </div>
          );
        })}
        ;
      </style.Wrap>
      <Footer title={title} />
    </div>
  );
}
