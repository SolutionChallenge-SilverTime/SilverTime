import React, { useState, useEffect } from "react";
import axios from "axios";
import { useLocation, useNavigate } from "react-router-dom";
import * as style from "./styles";
import Header from "../../../Components/Header/Header";
import Footer from "../../../Components/Footer/Footer";
import SearchBox from "../../../Components/SearchBox/SearchBox";
import Dropdown from "../../../Components/Dropdown/Dropdown";
import ClassCard from "../../../Components/ClassCard/ClassCard";
import YellowFullButton from "../../../Components/Button/YellowFullButton";
import FloatingButton from "../../../Components/Button/FloatingButton";

export default function ClassCategory() {
  const location = useLocation();
  const navigate = useNavigate();
  const title = "수업";
  const userId = sessionStorage.getItem("userId");
  const identity = sessionStorage.getItem("identity");
  const [adata, setData] = useState([]);

  const categoryOptions = [
    {
      id: 1,
      label: "전체",
      value: "all",
    },
    {
      id: 2,
      label: "교육",
      value: "education",
    },
    {
      id: 3,
      label: "취미",
      value: "hobby",
    },
    {
      id: 4,
      label: "건강",
      value: "health",
    },
    {
      id: 5,
      label: "친목",
      value: "social",
    },
  ];

  const orderOptions = [
    {
      id: 1,
      label: "인기순",
    },
    {
      id: 2,
      label: "최신순",
    },
    {
      id: 3,
      label: "거리순",
    },
  ];

  useEffect(() => {
    const url = `http://104.154.76.168:8080/user-lecture/all?category=${location.state.value}&sort=like&userId=${userId}`;
    axios
      .get(url)
      .then((response) => {
        setData(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, [userId]);

  const objArray = adata.map((item) => ({
    key: item.lectureId,
    src: item.imageUrl,
    className: item.title,
    classDays: item.monday,
    classTime: item.activityTime,
    classExplain: item.lectureIntro,
    distance: item.distance,
    location: item.location,
    starCount: item.likeCount,
    registerCount: `${item.presentPeople}/${item.maxPeople}`,
  }));

  const obj = {
    data: objArray,
  };

  return (
    <div>
      <Header title={title} />
      <style.Wrap>
        <SearchBox />
        {identity != 0 && <FloatingButton />}
        <style.TopBlock>
          <Dropdown
            options={categoryOptions}
            placeholder={location.state.category}
            backgroundColor={"#FF7F00"}
          />
          <Dropdown
            options={orderOptions}
            placeholder={"인기순"}
            backgroundColor={"#D3D3D3"}
          />
        </style.TopBlock>
        <YellowFullButton btnName={"정릉 3동 주민센터"} height={"30px"} />
        {obj.data.map((item) => {
          return (
            <ClassCard
              key={item.key}
              src={item.src}
              className={item.className}
              distance={item.distance}
              classDays={item.classDays}
              classTime={item.classTime}
              classExplain={item.classExplain}
              location={item.location}
              starCount={item.starCount}
              registerCount={item.registerCount}
              onClick={() => {
                navigate("/class", {
                  state: {
                    key: item.key,
                  },
                });
              }}
            />
          );
        })}
      </style.Wrap>
      <Footer title={title} />
    </div>
  );
}
