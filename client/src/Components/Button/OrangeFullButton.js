import React from "react";
import * as style from "./styles";

function OrangeFullButton(props) {
  return (
    <style.OrangeFullButton onClick={props.onClick}>
      <span>{props.btnName}</span>
    </style.OrangeFullButton>
  );
}

export default OrangeFullButton;