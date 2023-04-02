import React, { useState, useEffect } from "react";
import { useLocation } from "react-router-dom";
import axios from "axios";
import * as style from "./styles";
import Header from "../../../Components/Header/Header";
import Footer from "../../../Components/Footer/Footer";
import ClassIntro from "../../../Components/ClassDetail/ClassIntro/ClassIntro";
import Curriculum from "../../../Components/ClassDetail/Curriculum/Curriculum";
import TeacherIntro from "../../../Components/ClassDetail/TeacherIntro/TeacherIntro";
import Review from "../../../Components/ClassDetail/Review/Review";
import FloatingButton from "../../../Components/Button/FloatingButton";
import Modal from "../../../Components/Modal/Modal";
import { ModalProvider } from "styled-react-modal";

export default function Class(props) {
  const location = useLocation();
  const title = "수업";

  const userId = sessionStorage.getItem("userId");
  const identity = sessionStorage.getItem("identity");
  const id = location.state.key;

  const [adata, setData] = useState([]);
  const [current, setCurrent] = useState("classIntro");
  useEffect(() => {
    const url = `http://104.154.76.168:8080/lecture/detail/${location.state.key}`;
    axios
      .get(url)
      .then((response) => {
        setData(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, [userId]);

  console.log(adata.curriculumImagesUrl);

  const handleTagClick = (tag) => {
    setCurrent(tag);
  };

  const lectureImageArray = adata.instroductionImages?.map((item) => ({
    src: item.imageUrl,
  }));

  const curriculumArray = adata.curriculums?.map((item) => ({
    src: item.imageUrl,
    content: item.content,
  }));

  const reviewArray = adata.reviews?.map((item) => ({
    content: item.content,
    nickName: item.seniorNickName,
  }));

  const obj = {
    curriculumData: curriculumArray,
    reviewData: reviewArray,
  };

  return (
    <ModalProvider>
      <Header title={title} />
      {identity != 0 && <FloatingButton />}
      <style.Wrap>
        <style.SpanBlock>
          <span>
            {`${adata.tutorName}` +
              " | " +
              `${adata.categoryToKorean}` +
              " | " +
              `${adata.maxRegistrant}명 모집`}
          </span>
        </style.SpanBlock>
        <style.NameBlock>
          <span>{adata.title}</span>
        </style.NameBlock>
        <style.IconBlock>
          <img
            src={process.env.PUBLIC_URL + "/Images/ClassCard/StarIcon.svg"}
          />
          <style.DetailBlock>
            <span>{"이 글에 관심이 있어요"}</span>
            <span>{adata.likeCount}</span>
          </style.DetailBlock>
        </style.IconBlock>
        <style.IconBlock>
          <img src={process.env.PUBLIC_URL + "/Images/ClassCard/MenIcon.svg"} />
          <style.DetailBlock>
            <span>{"현재 신청 인원"}</span>
            <span>{`${adata.presentRegistrant}명 / ${adata.maxRegistrant}명`}</span>
          </style.DetailBlock>
        </style.IconBlock>
        <style.BottomBlock>
          <style.IconBlock>
            <img src={process.env.PUBLIC_URL + "/Images/Class/LinkIcon.svg"} />
            <span>{"공유하기"}</span>
          </style.IconBlock>
          <Modal />
          <style.IconBlock>
            <img src={process.env.PUBLIC_URL + "/Images/Class/CheckIcon.svg"} />
            <span onClick={() => alert("이 수업을 신청하시겠습니까?")}>
              {"신청하기"}
            </span>
          </style.IconBlock>
        </style.BottomBlock>
      </style.Wrap>
      <style.ContentBlock>
        <style.Wrap>
          <style.NavigateBlock>
            <style.SpanBlock textBold={current === "classIntro" ? 700 : 400}>
              <span
                onClick={() => {
                  handleTagClick("classIntro");
                }}
              >
                수업 소개
              </span>
            </style.SpanBlock>
            <style.SpanBlock textBold={current === "curriculum" ? 700 : 400}>
              <span
                onClick={() => {
                  handleTagClick("curriculum");
                }}
              >
                교육과정
              </span>
            </style.SpanBlock>
            <style.SpanBlock textBold={current === "teacherIntro" ? 700 : 400}>
              <span
                onClick={() => {
                  handleTagClick("teacherIntro");
                }}
              >
                선생님 소개
              </span>
            </style.SpanBlock>
            <style.SpanBlock textBold={current === "review" ? 700 : 400}>
              <span
                onClick={() => {
                  handleTagClick("review");
                }}
              >
                후기
              </span>
            </style.SpanBlock>
          </style.NavigateBlock>
          {current === "classIntro" && (
            <ClassIntro
              startDate={adata.startDate?.substr(0, 10)}
              endDate={adata.endDate?.substr(0, 10)}
              classDate={adata.adayOfWeek}
              classTime={adata.activityTime}
              explain={adata.instroduction}
              imageUrl={lectureImageArray}
            ></ClassIntro>
          )}
          {current === "curriculum" && (
            <div>
              {obj.curriculumData.map((item, index) => {
                return (
                  <Curriculum
                    week={`${index + 1}주차`}
                    src={item.src}
                    explain={item.content}
                  />
                );
              })}
            </div>
          )}
          {current === "teacherIntro" && (
            <TeacherIntro
              src={adata.profileUrl}
              name={adata.tutorName}
              gender={adata.gender}
              age={adata.birth.substr(0, 10)}
              explain={adata.tutorIntroduction}
            />
          )}
          {current === "review" && (
            <div>
              {obj.reviewData.map((item) => {
                return (
                  <Review nickname={item.nickName} review={item.content} />
                );
              })}
            </div>
          )}
        </style.Wrap>
      </style.ContentBlock>
      <Footer title={title} />
    </ModalProvider>
  );
}
