import React from "react";
import { useNavigate } from "react-router-dom";
import * as style from "./styles";
import FullButton from "../Button/FullButton";

export default function Header(props) {
  const navigate = useNavigate();

  return (
    <style.Wrap>
      <style.Title>
        {props.title === "실버타임" ? (
          <img
            src={process.env.PUBLIC_URL + "/Images/Logo/Logo.svg"}
            width={"50px"}
            height={"50px"}
          />
        ) : (
          <img
            src={process.env.PUBLIC_URL + "/Images/Header/BackIcon.svg"}
            onClick={() => {
              props.title === "회원가입" ? navigate("../") : navigate(-1);
            }}
            width={"30px"}
            height={"30px"}
          />
        )}
        <span>{props.title}</span>
        {props.title === "특이사항 작성" ? (
          <style.FlexBox>
            <img
              src={process.env.PUBLIC_URL + "/Images/Header/SaveIcon.svg"}
              onClick={props.onClick}
              width={"30px"}
              height={"30px"}
            />
            <FullButton
              btnName={"전송"}
              onClick={props.onClick}
              width={"30px"}
              height={"10px"}
            />
          </style.FlexBox>
        ) : props.title === "특이사항 확인" ? (
          <img
            src={process.env.PUBLIC_URL + "/Images/Header/TrashIcon.svg"}
            onClick={props.onClick}
            width={"40px"}
            height={"40px"}
          />
        ) : props.title === "내 정보" ? (
          <img
            src={process.env.PUBLIC_URL + "/Images/Header/SettingIcon.svg"}
            onClick={() => {
              navigate("../setting");
            }}
            width={"40px"}
            height={"40px"}
          />
        ) : (
          <span></span>
        )}
      </style.Title>
    </style.Wrap>
  );
}
