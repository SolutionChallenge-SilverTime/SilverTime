import React, { useEffect } from "react";
import * as style from "./styles";

export default function Chatbot() {
  useEffect(() => {
    (function(d, m){
      const kommunicateSettings = {
        "appId": "c4414d1878a1fcb5e4cf8473ff06680f",
        "popupWidget": true,
        "automaticChatOpenOnNavigation": true,
      };

      const s = document.createElement("script"); 
      s.type = "text/javascript"; 
      s.async = true;
      s.src = "https://widget.kommunicate.io/v2/kommunicate.app";

      const h = document.getElementsByTagName("head")[0]; 
      h.appendChild(s);

      window.kommunicate = m; 
      m._globals = kommunicateSettings;
    })(document, window.kommunicate || {});
  }, []);

  return (
    <style.ChatbotWrapper>
      <div></div>
    </style.ChatbotWrapper>
  );
}
