import React from "react";
import * as style from "./styles";

export default function Curriculum(props) {
  return (
    <style.Wrap>
      <style.WeekBlock>{props.week}</style.WeekBlock>
      <style.ImageBlock>
        <img src={props.src} />
      </style.ImageBlock>
      <style.ExplainBlock>{props.explain}</style.ExplainBlock>
    </style.Wrap>
  );
}
