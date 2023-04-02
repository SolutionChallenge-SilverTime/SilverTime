import React from "react";
import Header from "../../Components/Header/Header";
import Footer from "../../Components/Footer/Footer";
import NoteItem from "../../Components/NoteItem/NoteItem";

export default function Notice() {
  const title = "알림";

  const obj = {
    data: [
      {
        src: process.env.PUBLIC_URL + "/Images/Float/ChatbotIcon.svg",
        noticeTitle: "수업 알림",
        title: "내일 수업이 있습니다.",
      },

      {
        src: process.env.PUBLIC_URL + "/Images/Float/ChatbotIcon.svg",
        noticeTitle: "후기 알림",
        title: "후기 등록 가능한 수업이 있습니다.",
      },
    ],
  };

  return (
    <div>
      <Header title={title} />
      {obj.data.map((item, index) => {
        return (
          <NoteItem
            key={index}
            page={title}
            src={item.src}
            noticeTitle={item.noticeTitle}
            title={item.title}
          />
        );
      })}
      <Footer title={title} />
    </div>
  );
}
