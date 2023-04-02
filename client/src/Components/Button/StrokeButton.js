import React from "react";
import * as style from "./styles";

function StrokeButton(props) {
  return (
    <style.StrokeButton onClick={props.onClick}>
      <span>{props.btnName}</span>
    </style.StrokeButton>
  );
}

export default StrokeButton;