import React from "react";
import * as style from "./styles";
import Header from "../../Components/Header/Header";
import FloatingButton from "../../Components/Button/FloatingButton";
import Footer from "../../Components/Footer/Footer";
import SearchBox from "../../Components/SearchBox/SearchBox";
import ClassCard from "../../Components/ClassCard/ClassCard";

export default function Search() {
  const title = "검색";

  return (
    <div>
      <Header title={title} />
      <style.Wrap>
        <FloatingButton usertype="teacher" />
        <SearchBox />
        <style.TitleBlock>관심 급상승 수업</style.TitleBlock>
        <ClassCard />
      </style.Wrap>
      <Footer title={title} />
    </div>
  );
}
