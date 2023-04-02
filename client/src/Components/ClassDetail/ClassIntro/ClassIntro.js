import React from "react";
import * as style from "./styles";

export default function ClassIntro(props) {
  const imageUrl = props.imageUrl;
  console.log(imageUrl);

  return (
    <div>
      <style.Wrap>
        <style.ClassBlock>{"시작일: " + props.startDate}</style.ClassBlock>
        <style.ClassBlock>{"종료일: " + props.endDate}</style.ClassBlock>
        <style.ClassBlock>
          {"수업 시간: " + props.classDate + " " + props.classTime}
        </style.ClassBlock>
      </style.Wrap>
      <style.BottomBlock>
        <style.ExplainBlock>{props.explain}</style.ExplainBlock>
        <style.ImageBlock>
          <style.ImageTopBlock>
            {props.imageUrl && imageUrl.length >= 1 && (
              <img src={imageUrl[0].src} />
            )}
            {props.imageUrl && imageUrl.length >= 2 && (
              <img src={imageUrl[1].src} />
            )}
          </style.ImageTopBlock>
          <style.ImageBottomBlock>
            {props.imageUrl && imageUrl.length >= 3 && (
              <img src={imageUrl[2].src} />
            )}
            {props.imageUrl && imageUrl.length >= 4 && (
              <img src={imageUrl[3].src} />
            )}
          </style.ImageBottomBlock>
        </style.ImageBlock>
      </style.BottomBlock>
    </div>
  );
}
