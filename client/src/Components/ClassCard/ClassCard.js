import React from "react";
import * as style from "./styles";

export default function ClassCard(props) {
  return (
    <style.Wrap onClick={props.onClick}>
      <img src={props.src} />
      <style.TopBlock>
        <span>{props.className}</span>
        <style.TimeBlock>
          <span>{props.classDays}</span>
          <span>{props.classTime}</span>
        </style.TimeBlock>
      </style.TopBlock>
      <style.ExplainBlock>{props.classExplain}</style.ExplainBlock>
      <style.ETCBlock>
        <style.DistanceBlock>
          {props.distance && <span>{props.distance + " m"}</span>}
        </style.DistanceBlock>
        <style.ClassInfoBlock>
          <style.IconBlock>
            <img
              src={process.env.PUBLIC_URL + "/Images/ClassCard/MapIcon.svg"}
            />
            <span>{props.location}</span>
          </style.IconBlock>
          <style.BottomBlock>
            <style.IconBlock>
              <img
                src={process.env.PUBLIC_URL + "/Images/ClassCard/StarIcon.svg"}
              />
              <span>{props.starCount}</span>
            </style.IconBlock>
            <style.IconBlock>
              <img
                src={process.env.PUBLIC_URL + "/Images/ClassCard/MenIcon.svg"}
              />
              <span>{props.registerCount}</span>
            </style.IconBlock>
          </style.BottomBlock>
        </style.ClassInfoBlock>
      </style.ETCBlock>
    </style.Wrap>
  );
}
