import React from "react";
import { useNavigate } from "react-router-dom";
import * as style from "./style";
import Chatbot from "../../Pages/Chatbot/Chatbot";

export default function Footer(props) {
  const navigate = useNavigate();
  const identity = sessionStorage.getItem("identity");

  return (
    <style.Wrap>
      <style.Menu>
        {identity == 0 && <Chatbot />}
        <style.BtnLink>
          {props.title !== "실버타임" ? (
            <img
              src={process.env.PUBLIC_URL + "/Images/Footer/MainIcon.svg"}
              onClick={() => {
                navigate("../main");
              }}
            />
          ) : (
            <img
              src={process.env.PUBLIC_URL + "/Images/Footer/MainSelectIcon.svg"}
            />
          )}
        </style.BtnLink>
        <style.BtnLink>
          {props.title !== "AI 추천 수업" ? (
            <img
              src={process.env.PUBLIC_URL + "/Images/Footer/RecommendIcon.svg"}
              onClick={() => {
                navigate("../aiClass");
              }}
            />
          ) : (
            <img
              src={
                process.env.PUBLIC_URL +
                "/Images/Footer/RecommendSelectIcon.svg"
              }
            />
          )}
        </style.BtnLink>
        <style.BtnLink>
          {props.title !== "내 수업" ? (
            <img
              src={process.env.PUBLIC_URL + "/Images/Footer/MyClassIcon.svg"}
              onClick={() => {
                navigate("../myClass");
              }}
            />
          ) : (
            <img
              src={
                process.env.PUBLIC_URL + "/Images/Footer/MyClassSelectIcon.svg"
              }
            />
          )}
        </style.BtnLink>
        <style.BtnLink>
          {props.title !== "알림" ? (
            <img
              src={process.env.PUBLIC_URL + "/Images/Footer/NoticeIcon.svg"}
              onClick={() => {
                navigate("../notice");
              }}
            />
          ) : (
            <img
              src={
                process.env.PUBLIC_URL + "/Images/Footer/NoticeSelectIcon.svg"
              }
            />
          )}
        </style.BtnLink>
        <style.BtnLink>
          {props.title !== "내 정보" ? (
            <img
              src={process.env.PUBLIC_URL + "/Images/Footer/MyPageIcon.svg"}
              onClick={() => {
                navigate("../myPage");
              }}
            />
          ) : (
            <img
              src={
                process.env.PUBLIC_URL + "/Images/Footer/MyPageSelectIcon.svg"
              }
            />
          )}
        </style.BtnLink>
      </style.Menu>
    </style.Wrap>
  );
}
