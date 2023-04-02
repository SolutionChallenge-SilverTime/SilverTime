import React from "react";
import * as style from "./styles";

function CloseButton(props) {
  return (
    <style.CloseButton onClick={props.onClick} id={props.id}>
      {props.btnName}
    </style.CloseButton>
  );
}

export default CloseButton;