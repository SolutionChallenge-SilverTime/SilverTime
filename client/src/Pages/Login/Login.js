import React, { useState } from "react";
import { useNavigate } from "react-router";
import axios from "axios";
import * as style from "./styles";
import Input from "../../Components/Input/Input";
import OrangeFullButton from "../../Components/Button/OrangeFullButton";
import OrangeStrokeButton from "../../Components/Button/OrangeStrokeButton";
import FullButton from "../../Components/Button/FullButton";
import StrokeButton from "../../Components/Button/StrokeButton";

export default function Login() {
  const navigate = useNavigate();

  const [usertype, setUsertype] = useState("");
  const [nickname, setNickname] = useState("");
  const [pw, setPw] = useState("");
  const [identity, setIdentity] = useState(0);

  const onClickSenior = () => {
    setUsertype("senior");
    setIdentity(0);
  };
  const onClickProtector = () => {
    setUsertype("protector");
    setIdentity(1);
  };
  const onClickTeacher = () => {
    setUsertype("teacher");
    setIdentity(2);
  };

  const handleNickname = (e) => {
    setNickname(e.target.value);
  };

  const handlePw = (e) => {
    setPw(e.target.value);
  };

  const onClickLoginButton = () => {
    axios
      .post(
        "http://104.154.76.168:8080/auth/signin",

        JSON.stringify({
          identity: identity,
          nickName: nickname,
          password: pw,
        }),

        {
          headers: { "Content-Type": `application/json` },
        }
      )
      .then(function (resp) {
        console.log(resp.data);
        if (resp.data !== null && resp.data !== "") {
          console.log("로그인 성공");
          sessionStorage.setItem("nickName", Object.values(resp.data)[0]);
          sessionStorage.setItem("userId", Object.values(resp.data)[2]);
          sessionStorage.setItem("identity", Object.values(resp.data)[3]);
          navigate("/main", {
            state: {
              usertype: usertype,
            },
          });
        } else {
          alert("로그인 실패", "아이디나 비밀번호를 확인하세요.");
          setNickname("");
          setPw("");
        }
      })
      .catch(function (err) {
        console.log(`Error Message: ${err}`);
      });
  };

  return (
    <style.Wrap>
      <style.LogoBlock>
        <img
          className="logoImg"
          alt="로고 이미지"
          src={process.env.PUBLIC_URL + "/Images/Logo/Logo.svg"}
          style={{ width: "300px", height: "300px", borderRadius: "20px" }}
        />
      </style.LogoBlock>
      <span
        className="type"
        style={{ fontWeight: "600", fontSize: "20px", color: "#141414" }}
      >
        사용자 유형
      </span>
      <style.TypeButtonBlock>
        {usertype === "senior" ? (
          <OrangeFullButton
            onClick={onClickSenior}
            btnName={"어르신"}
          ></OrangeFullButton>
        ) : (
          <OrangeStrokeButton
            onClick={onClickSenior}
            btnName={"어르신"}
          ></OrangeStrokeButton>
        )}
        {usertype === "protector" ? (
          <OrangeFullButton
            onClick={onClickProtector}
            btnName={"보호자"}
          ></OrangeFullButton>
        ) : (
          <OrangeStrokeButton
            onClick={onClickProtector}
            btnName={"보호자"}
          ></OrangeStrokeButton>
        )}
        {usertype === "teacher" ? (
          <OrangeFullButton
            onClick={onClickTeacher}
            btnName={"선생님"}
          ></OrangeFullButton>
        ) : (
          <OrangeStrokeButton
            onClick={onClickTeacher}
            btnName={"선생님"}
          ></OrangeStrokeButton>
        )}
      </style.TypeButtonBlock>
      <Input
        name={"nickname"}
        onChange={handleNickname}
        title={"닉네임"}
        value={nickname}
        placeholder={"닉네임을 입력해주세요."}
        titleWeight={600}
      />
      <Input
        name={"password"}
        onChange={handlePw}
        title={"비밀번호"}
        value={pw}
        placeholder={"비밀번호를 입력해주세요."}
        titleWeight={600}
      />
      <style.ButtonBlock>
        <div>
          <FullButton onClick={onClickLoginButton} btnName={"로그인"} />
          <StrokeButton className="bottomButton" btnName={"회원가입"} />
        </div>
      </style.ButtonBlock>
    </style.Wrap>
  );
}
