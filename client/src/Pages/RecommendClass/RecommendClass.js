import React, { useState, useEffect } from "react";
import axios from "axios";
import * as style from "./styles";
import { useNavigate } from "react-router-dom";
import Header from "../../Components/Header/Header";
import FloatingButton from "../../Components/Button/FloatingButton";
import Footer from "../../Components/Footer/Footer";
import SearchBox from "../../Components/SearchBox/SearchBox";
import ClassCard from "../../Components/ClassCard/ClassCard";

export default function RecommendClass() {
  const title = "AI 추천 수업";
  const [adata, setData] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    const url = `http://104.154.76.168:8080/lecture/recommend`;
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
    key: item.lectureId,
    src: item.imageUrl,
    className: item.title,
    classDays: item.adayOfWeek,
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
        <FloatingButton usertype="teacher" />
        <SearchBox />
        <style.TitleBlock>AI 추천 수업</style.TitleBlock>
        {obj.data.map((item) => {
          return (
            <ClassCard
              key={item.key}
              src={item.src}
              className={item.className}
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
