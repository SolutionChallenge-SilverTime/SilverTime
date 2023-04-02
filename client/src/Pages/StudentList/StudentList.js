import React, { useState, useEffect } from "react";
import * as style from "./styles";
import axios from "axios";
import Header from "../../Components/Header/Header";
import Footer from "../../Components/Footer/Footer";
import StudentItem from "../../Components/StudentItem/StudentItem";
import { useLocation } from "react-router-dom";
export default function StudentList(props) {
  const location = useLocation();
  const title = "수강생 목록";
  const [adata, setData] = useState([]);
  console.log(location.state.key);
  useEffect(() => {
    const url = `http://104.154.76.168:8080/auth/tutor/appliedSenior?lectureId=${location.state.key}`;
    axios
      .get(url)
      .then((response) => {
        setData(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);
  const objArray = adata.map((item) => ({
    key: item.userId,
    address: item.address,
    gender: item.gender,
    birth: item.birth,
    name: item.name,
  }));
  const obj = {
    data: objArray,
  };
  return (
    <div>
      <Header title={title} />
      <style.TitleBlock>
        <span>{"뜨개질 수업"}</span>
      </style.TitleBlock>
      {obj.data.map((item) => {
        return (
          <StudentItem
            key={item.key}
            className={location.state.clss}
            src={process.env.PUBLIC_URL + "/Images/Float/ChatbotIcon.svg"}
            seniorName={item.name}
            age={item.birth?.substr(0, 10)}
            gender={item.gender}
            location={item.address}
          />
        );
      })}
      <Footer title={title} />
    </div>
  );
}
