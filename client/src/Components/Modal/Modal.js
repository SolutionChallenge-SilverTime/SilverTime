import { React, useState } from "react";
import * as style from "./style";
import CloseButton from "../Button/CloseButton";
import Map from "../Map/Map";

export default function Modal2() {
  const [isOpen, setIsOpen] = useState(false);

  const toggleModal = (e) => {
    setIsOpen(!isOpen);
  };

  return (
    <div>
      <style.IconBlock>
        <img src={process.env.PUBLIC_URL + "/Images/Class/MapIcon.svg"} />
        <span onClick={toggleModal}>{"위치정보"}</span>
      </style.IconBlock>
      <style.TypeModal
        isOpen={isOpen}
        onBackgroundClick={toggleModal}
        onEscapeKeyDown={toggleModal}
      >
        <CloseButton onClick={toggleModal} btnName={"X"} />
        <Map />
      </style.TypeModal>
    </div>
  );
}
