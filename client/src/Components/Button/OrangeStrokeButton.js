import React from "react";
import * as style from "./styles";

function OrangeStrokeButton(props) {
  return (
    <style.OrangeStrokeButton onClick={props.onClick}>
      <span>{props.btnName}</span>
    </style.OrangeStrokeButton>
  );
}

export default OrangeStrokeButton;