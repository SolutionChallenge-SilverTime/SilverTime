import React from "react";
import * as style from "./styles";

export default function Input(props) {
  return (
    <style.Wrap backgroundColor={props.backgroundColor} top={props.top}>
      <style.TitleBlock
        titleWeight={props.titleWeight}
        titleSize={props.titleSize}
      >
        {props.title && <span>{props.title}</span>}
      </style.TitleBlock>
      <style.InputBlock
        inputheight={props.inputheight}
        stroke={props.stroke}
        backgroundColor={props.backgroundColor}
        fontWeight={props.fontWeight}
        fontSize={props.fontSize}
        border={props.border}
        placeholderColor={props.placeholderColor}
      >
        {props.src && (
          <img src={props.src} width={props.width} height={props.height} />
        )}
        <input
          name={props.name}
          onClick={props.onClick}
          type={props.type || "text"}
          placeholder={props.placeholder}
          onChange={props.onChange}
          value={props.value}
        />
      </style.InputBlock>
    </style.Wrap>
  );
}
