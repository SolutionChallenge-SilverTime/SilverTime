import React from "react";
import * as style from "./styles";

function FullButton(props) {
  return (
    <style.FullButton
      padding={props.padding}
      onClick={props.onClick}
      width={props.width}
      height={props.height}
      fontSize={props.fontSize}
      color={props.color}
    >
      {props.src && <img src={props.src} />}
      {props.btnName}
    </style.FullButton>
  );
}

export default FullButton;
