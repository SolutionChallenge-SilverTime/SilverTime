import React, { useState } from "react";
import * as style from "./styles";
import Header from "../../Components/Header/Header";
import Footer from "../../Components/Footer/Footer";

export default function Setting() {
  const title = "설정";
  const [mySwitchFirst, setMySwitchFirst] = useState(false);
  const [mySwitchSecond, setMySwitchSecond] = useState(false);

  const switchClickedFirst = () => {
    setMySwitchFirst(!mySwitchFirst);
  };

  const switchClickeSecond = () => {
    setMySwitchSecond(!mySwitchSecond);
  };

  return (
    <div>
      <Header title={title} />
      <div>
        <style.TitleBlock>개인정보</style.TitleBlock>
        <style.ItemBlock>
          <div>비밀번호 변경하기</div>
          <img src={process.env.PUBLIC_URL + "/Images/Setting/NextIcon.svg"} />
        </style.ItemBlock>
      </div>
      <div>
        <style.TitleBlock>앱</style.TitleBlock>
        <style.ItemBlock>
          <div>알림 설정</div>
          <style.MySwitch onClick={switchClickedFirst} mySwitch={mySwitchFirst}>
            <div></div>
          </style.MySwitch>
        </style.ItemBlock>
        <style.ItemBlock>
          <div>큰 글씨 설정</div>
          <style.MySwitch
            onClick={switchClickeSecond}
            mySwitch={mySwitchSecond}
          >
            <div></div>
          </style.MySwitch>
        </style.ItemBlock>
      </div>
      <div>
        <style.TitleBlock>정보</style.TitleBlock>
        <style.ItemBlock>
          <div>개인정보 처리방침</div>
          <img src={process.env.PUBLIC_URL + "/Images/Setting/NextIcon.svg"} />
        </style.ItemBlock>
        <style.ItemBlock>
          <div>서비스 이용방침</div>
          <img src={process.env.PUBLIC_URL + "/Images/Setting/NextIcon.svg"} />
        </style.ItemBlock>
        <style.ItemBlock>
          <div>버전 정보</div>
          <span>v0.0.1</span>
        </style.ItemBlock>
        <style.ItemBlock>
          <div>로그아웃</div>
        </style.ItemBlock>
      </div>
      <Footer title={title} />
    </div>
  );
}
