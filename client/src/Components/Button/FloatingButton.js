import React from "react";
import { useNavigate } from "react-router-dom";
import * as style from "./styles";

export default function FloatingButton() {
  const navigate = useNavigate();
  const identity = sessionStorage.getItem("identity");

  return (
    <style.FloatingButton>
      {identity == 1 && (
        <img
          onClick={() => navigate("../noteList")}
          src={process.env.PUBLIC_URL + "/Images/Float/ChatbotIcon.svg"}
        />
      )}
      {identity == 2 && (
        <img
          onClick={() => navigate("../noteSend")}
          src={process.env.PUBLIC_URL + "/Images/Float/WriteIcon.svg"}
        />
      )}
    </style.FloatingButton>
  );
}
