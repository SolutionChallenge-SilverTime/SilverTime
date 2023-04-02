import React from "react";
import * as style from "./styles";

export default function NoteItem(props) {
  const identity = sessionStorage.getItem("identity");

  return (
    <style.Wrap onClick={props.onClick}>
      <img src={props.src} />
      <style.RightBlock>
        <style.TopBlock>
          <style.NameBlock>
            {props.page !== "알림" && identity == 1 ? (
              <span>{props.tutorName} 선생님</span>
            ) : (
              <span>{props.guardianName} 보호자</span>
            )}

            {props.page === "알림" && <span>{props.noticeTitle}</span>}
            <span>{props.className}</span>
          </style.NameBlock>
          <span>{props.date}</span>
        </style.TopBlock>
        <span>{props.title}</span>
      </style.RightBlock>
    </style.Wrap>
  );
}
