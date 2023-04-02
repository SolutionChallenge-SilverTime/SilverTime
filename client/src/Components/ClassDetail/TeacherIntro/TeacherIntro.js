import React from "react";
import * as style from "./styles";

export default function TeacherIntro(props) {
  return (
    <style.Wrap>
      <style.TopBlock>
        <img src={props.src} />
        <div>
          <style.SpanBlock>{props.name}</style.SpanBlock>
          <style.SpanBlock>{props.gender}</style.SpanBlock>
          <style.SpanBlock>{props.age}</style.SpanBlock>
        </div>
      </style.TopBlock>
      <style.ExplainBlock>{props.explain}</style.ExplainBlock>
    </style.Wrap>
  );
}
