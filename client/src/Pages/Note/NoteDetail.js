import * as style from "./styles";
import Header from "../../Components/Header/Header";
import Footer from "../../Components/Footer/Footer";
import NoteItem from "../../Components/NoteItem/NoteItem";
import React from "react";
import { useLocation } from "react-router-dom";

export default function NoteDetail() {
  const title = "특이사항 확인";
  const location = useLocation();

  return (
    <div>
      <Header title={title} />
      <style.DetailWrap>
        <div>
          <span>{location.state.className}</span>
        </div>
        <NoteItem
          src={location.state.src}
          tutorName={location.state.tutorName}
          guardianName={location.state.guardianName}
          date={location.state.date}
          title={location.state.seniorName}
        />
        <div>{location.state.title}</div>
        <div>{location.state.content}</div>
      </style.DetailWrap>
      <Footer title={title} />
    </div>
  );
}