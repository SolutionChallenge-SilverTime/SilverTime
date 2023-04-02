import React from "react";
import * as style from "./styles";

function YellowFullButton(props) {
  return (
    <style.YellowFullButton 
      onClick={props.onClick}
      width={props.width}
      height={props.height}
    >
      <span>{props.btnName}</span>
    </style.YellowFullButton>
  );
}

export default YellowFullButton;