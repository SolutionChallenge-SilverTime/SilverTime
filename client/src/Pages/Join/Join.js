import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router";
import { useLocation } from "react-router";
import * as style from "./styles";
import Input from "../../Components/Input/Input";
import OrangeFullButton from "../../Components/Button/OrangeFullButton";
import OrangeStrokeButton from "../../Components/Button/OrangeStrokeButton";
import Header from "../../Components/Header/Header";

export default function Join(props) {
    const navigate = useNavigate();
    const location = useLocation();

    const [startDate, setStartDate] = useState(new Date());
    
    const [userInfo, setUserInfo] = useState({
        nickname: "",
        pw: "",
        name: "",
        birth: "",
        email: "",
        gender: "",
        phone: "",
        adderess: "",
        interest: "",
    });
    const [pwchk, setPwchk] = useState("");
    
    // const handleNickname = (e) => {
    //     setNickname(e.target.value);
    //     const regex = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣|0-9]/;
    //     if (regex.test(e.target.value)) {
    //         setNicknameValid(true);
    //     } else {
    //         setNicknameValid(false);
    //     }
    // };

    // const handlePw = (e) => {
    //     setPw(e.target.value);
    //     const regex = /^[A-Za-z0-9]{8,20}$/;
    //     if (regex.test(e.target.value)) {
    //         setPwValid(true);
    //     } else {
    //         setPwValid(false);
    //     }
    // };

    return (
        <div>
            <Header title="회원가입" />
            <style.Wrap>
                <style.LogoBlock>
                    <img className="userImg" alt="로고 이미지" src={process.env.PUBLIC_URL + "/Images/Join/UserImgIcon.svg"} />
                </style.LogoBlock>
                <h2>회원 정보</h2>
                <span style={{ fontWeight: "600", fontSize: "16px", color: "#141414"}}>선택된 사용자 유형</span>
                <OrangeStrokeButton btnName={location.state.usertype}></OrangeStrokeButton>
                <style.NicknameBlock>
                    <Input
                    name={"nickname"}
                    title={"닉네임"}
                    />
                    <OrangeFullButton btnName={"중복확인"} margin={"15px 0 0 10px"}></OrangeFullButton>
                </style.NicknameBlock>
                <Input
                    name={"pw"}
                    title={"비밀번호"} 
                />
                <Input
                    name={"pwchk"}
                    title={"비밀번호 확인"} 
                />
                <Input
                    name={"name"}
                    title={"이름"} 
                />
                <style.BirthBlock>
                    <span>생년월일</span>
                </style.BirthBlock>
                <span>성별</span>
                <Input
                    name={"phone"}
                    title={"전화번호"}
                />
                <span>거주지</span>
            </style.Wrap>
        </div>
        
    )

}