import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import * as style from "./styles";
import FullButton from "../../Components/Button/FullButton";
import Footer from "../../Components/Footer/Footer";
import Header from "../../Components/Header/Header";
import FloatingButton from "../../Components/Button/FloatingButton";

export default function Main() {
  const title = "실버타임";
  const navigate = useNavigate();
  const identity = sessionStorage.getItem("identity");
  console.log(identity != 0);

  // useEffect(() => {
  //   if (sessionStorage.getItem("nickName") === null) {
  //     console.log("isLogin ?? :: ", nick);
  //   } else {
  //     setNick(sessionStorage.getItem("nickName"));
  //     setUserId(sessionStorage.getItem("userId"));
  //     setIdentity(sessionStorage.getItem("identity"));
  //     console.log("nickName :: ", nick);
  //     console.log("userId ::", userId);
  //     console.log("identity :: ", identity);
  //   }
  // }, []);
  return (
    <div>
      <Header title={title} />
      <style.Wrap>
        <FloatingButton />
        <FullButton
          fontSize={"30px"}
          btnName={"전체"}
          onClick={() =>
            navigate("../classCategory", {
              state: { category: "전체", value: "all" },
            })
          }
          src={process.env.PUBLIC_URL + "Images/Main/All.svg"}
        />
        <FullButton
          fontSize={"30px"}
          btnName={"교육"}
          onClick={() =>
            navigate("../classCategory", {
              state: { category: "교육", value: "education" },
            })
          }
          src={process.env.PUBLIC_URL + "Images/Main/EducationIcon.svg"}
        />
        <FullButton
          fontSize={"30px"}
          btnName={"취미"}
          onClick={() =>
            navigate("../classCategory", {
              state: { category: "취미", value: "hobby" },
            })
          }
          src={process.env.PUBLIC_URL + "Images/Main/InterestIcon.svg"}
        />
        <FullButton
          fontSize={"30px"}
          btnName={"건강"}
          onClick={() =>
            navigate("../classCategory", {
              state: { category: "건강", value: "health" },
            })
          }
          src={process.env.PUBLIC_URL + "Images/Main/HealthIcon.svg"}
        />
        <FullButton
          fontSize={"30px"}
          btnName={"친목"}
          onClick={() =>
            navigate("../classCategory", {
              state: { category: "친목", value: "social" },
            })
          }
          src={process.env.PUBLIC_URL + "Images/Main/AmityIcon.svg"}
        />
      </style.Wrap>
      <Footer title={title} />
    </div>
  );
}
