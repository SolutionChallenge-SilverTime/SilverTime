import React, { useState } from "react";
import * as style from "./styles";
import Header from "../../Components/Header/Header";
import Footer from "../../Components/Footer/Footer";
import Input from "../../Components/Input/Input";
import axios from "axios";
import { useNavigate, useLocation } from "react-router";

export default function NoteSend() {
  const navigate = useNavigate();
  const location = useLocation();
  const title = "특이사항 작성";

  const [guardianName, setGuardianName] = useState("");
  const [seniorName, setSeniorName] = useState("");
  const [className, setClassName] = useState("");
  const [noteTitle, setNoteTitle] = useState("");
  const [noteContent, setNoteContent] = useState("");

  const handleGuardianName = (e) => {
    setGuardianName(e.target.value);
  };

  const handleSeniorName = (e) => {
    setSeniorName(e.target.value);
  };

  const handleClassName = (e) => {
    setClassName(e.target.value);
  };

  const handleNoteTitle = (e) => {
    setNoteTitle(e.target.value);
  };

  const handleNoteContent = (e) => {
    setNoteContent(e.target.value);
  };

  const clickNoteButton = () => {
    axios
      .post(
        "http://104.154.76.168:8080/significant/send",
        JSON.stringify({
          gurdianNickName: guardianName,
          tutorNickName: sessionStorage.getItem("nickName"),
          seniorName: seniorName,
          title: noteTitle,
          lectureName: className,
          content: noteContent,
        }),
        {
          headers: { "Content-Type": `application/json` },
        }
      )
      .then(function (resp) {
        console.log(resp.data);
        if (resp.data !== null && resp.data !== "") {
          alert("특이사항을 전송하시겠습니까?");
          navigate("/noteList");
        } else {
          alert("실패");
        }
      })
      .catch(function (err) {
        console.log(`Error Message: ${err}`);
      });
  };

  return (
    <div>
      <Header title={title} onClick={clickNoteButton} />
      <style.Wrap>
        <Input
          title={"보호자"}
          border={"#FF7F00"}
          titleWeight={"500"}
          titleSize={"23px"}
          onChange={handleGuardianName}
        />
        <Input
          title={"어르신"}
          border={"#FF7F00"}
          titleWeight={"500"}
          titleSize={"23px"}
          onChange={handleSeniorName}
        />
        <Input
          title={"클래스 이름"}
          border={"#FF7F00"}
          titleWeight={"500"}
          titleSize={"23px"}
          onChange={handleClassName}
        />
        <Input
          title={"제목"}
          border={"#FF7F00"}
          titleWeight={"500"}
          titleSize={"23px"}
          onChange={handleNoteTitle}
        />
        <Input
          inputheight={"150px"}
          title={"특이사항 작성"}
          border={"#FF7F00"}
          titleWeight={"500"}
          titleSize={"23px"}
          onChange={handleNoteContent}
        />
      </style.Wrap>
      <Footer title={title} />
    </div>
  );
}
