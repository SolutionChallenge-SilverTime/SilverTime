import React from "react";
import * as style from "./styles";

export default function Review(props) {
  return (
    <style.ReviewBlock>
      <style.SpanBlock>
        <span>{props.nickname}</span>
      </style.SpanBlock>
      <style.SpanBlock>
        <span>{props.review}</span>
      </style.SpanBlock>
    </style.ReviewBlock>
  );
}
