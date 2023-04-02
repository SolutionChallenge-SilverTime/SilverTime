import React from "react";
import { useNavigate } from "react-router-dom";
import * as style from "./styles";
import FullButton from "../Button/FullButton";

export default function StudentItem(props) {
  const navigate = useNavigate();

  return (
    <style.Wrap onClick={props.onClick}>
      <img src={props.src} />
      <style.RightBlock>
        <style.InfoBlock>
          <span>{props.seniorName} 어르신</span>
          <span>{props.age}</span>
          <span>{props.gender}</span>
          <span>{props.location}</span>
        </style.InfoBlock>
        <FullButton
          padding={"10px"}
          width={"120px"}
          fontSize={"22px"}
          color={"#ffffff"}
          btnName={"특이사항 작성하기"}
          onClick={() => {
            navigate("../noteSend", {
              state: {
                className: props.className,
                seniorName: props.seniorName,
              },
            });
          }}
        />
      </style.RightBlock>
    </style.Wrap>
  );
}
