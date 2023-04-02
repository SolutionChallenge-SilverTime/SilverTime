import React, { useState, useEffect } from "react";
import axios from "axios";
import * as style from "./styles";
import Input from "../../Components/Input/Input";
import OrangeFullButton from "../../Components/Button/OrangeFullButton";
import Header from "../../Components/Header/Header";
import Footer from "../../Components/Footer/Footer";

export default function MyPage() {
  const title = "내 정보";
  const userId = sessionStorage.getItem("userId");
  const [adata, setData] = useState([]);
  useEffect(() => {
    const url = `http://104.154.76.168:8080/auth/tutor/mypage/${userId}`;
    axios
      .get(url)
      .then((response) => {
        setData(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);
  console.log(adata);
  return (
    <div>
      <Header title={title} />
      <style.Wrap>
        <style.LogoBlock>
          <img className="userImg" alt="로고 이미지" src={adata.profileUrl} />
        </style.LogoBlock>
        <h2>회원 정보</h2>
        <Input
          name={adata.nickName}
          title={"닉네임"}
          placeholder={adata.nickName}
        />
        <Input
          name={adata.password}
          title={"비밀번호"}
          placeholder={adata.password}
        />
        <Input name={adata.name} title={"이름"} placeholder={adata.password} />
        <Input name={adata.gender} title={"성별"} placeholder={adata.gender} />
        <Input
          name={adata.birth?.substr(0, 10)}
          title={"생년월일"}
          placeholder={adata.birth?.substr(0, 10)}
        />
        <Input name={adata.email} title={"이메일"} placeholder={adata.email} />
        <Input
          name={adata.phone}
          title={"전화번호"}
          placeholder={adata.phone}
        />
        <Input
          name={adata.address}
          title={"교육활동지"}
          placeholder={adata.address}
        />
        <Input
          name={adata.introduction}
          title={"소개"}
          placeholder={adata.introduction}
        />
        <style.ButtonBlock>
          <OrangeFullButton
            btnName={"수정하기"}
            onClick={() => {
              alert("정보를 수정하시겠습니까?");
            }}
          />
        </style.ButtonBlock>
      </style.Wrap>
      <Footer title={title} />
    </div>
  );
}
