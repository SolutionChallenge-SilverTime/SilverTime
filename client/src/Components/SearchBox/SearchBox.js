import React from "react";
import * as style from "./styles";
import Input from "../Input/Input";

export default function SearchBox(props) {
  return (
    <style.Wrap backgroundColor={props.color || "#D9D9D9"}>
      <Input
        top={"0px"}
        width={props.width}
        height={props.height}
        stroke={props.color || "#D9D9D9"}
        fontWeight={"500"}
        fontSize={"24px"}
        color={props.color || ""}
        border={props.color || "#D9D9D9"}
        backgroundColor={props.color || "#D9D9D9"}
        placeholder={"단어를 검색해 보세요."}
        placeholderColor={props.placeholderColor}
        src={
          props.page
            ? process.env.PUBLIC_URL + "/Images/Search/NoteSearchIcon.svg"
            : process.env.PUBLIC_URL + "/Images/Search/SearchIcon.svg"
        }
      />
    </style.Wrap>
  );
}
