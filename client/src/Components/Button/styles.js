import styled from "styled-components";

export const CloseButton = styled.div`
  margin-left: auto;
  margin-bottom: 10px;
  border: none;
  color: #141414;
  font-weight: 700;
  font-size: 26px;
  background-color: transparent;
`;

export const FloatingButton = styled.div`
  position: fixed;
  width: 100%;
  max-width: 480px;
  top: 600px;
  left: 860px;
  z-index: 100;
  @media only screen and (max-width: 480px) {
    top: 580px;
    left: 380px;
  }
`;

export const FullButton = styled.div`
  width: ${(props) => props.width};
  height: ${(props) => props.height};
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 20px 0;
  background: #ff7f00;
  border-radius: 20px;
  padding: ${(props) => props.padding || "20px"};
  color: ${(props) => props.color || "black"};
  font-weight: 700;
  font-size: ${(props) => props.fontSize || "20px"};
  text-align: center;
  box-shadow: 5px 5px 15px rgba(0, 0, 0, 0.1);
  cursor: pointer;
  > img {
    width: 25%;
    height: 25%;
    margin-right: 20px;
  }
`;

export const OrangeFullButton = styled.div`
  width: 120px;
  height: ${(props) => props.height};
  margin: ${(props) => props.margin};
  background: #ff9900;
  border-radius: 10px;
  padding: 10px;
  color: #ffffff;
  font-weight: 700;
  font-size: 20px;
  text-align: center;
  box-shadow: 5px 5px 15px rgba(0, 0, 0, 0.1);
  cursor: pointer;
`;

export const YellowFullButton = styled.div`
  width: ${(props) => props.width};
  height: ${(props) => props.height};
  margin-top: 15px;
  padding: 10px;
  background: #ffb800;
  border-radius: 10px;
  color: #ffffff;
  font-weight: 700;
  font-size: 25px;
  text-align: center;
  box-shadow: 5px 5px 15px rgba(0, 0, 0, 0.1);
  cursor: pointer;
`;

export const StrokeButton = styled.div`
  height: ${(props) => props.height};
  background: #ffffff;
  border: 2px solid #ff7f00;
  border-radius: 10px;
  padding: 10px;
  color: #141414;
  font-weight: 700;
  font-size: 20px;
  text-align: center;
  box-shadow: 5px 5px 15px rgba(0, 0, 0, 0.1);
  cursor: pointer;
`;

export const OrangeStrokeButton = styled.div`
  width: 120px;
  height: ${(props) => props.height};
  background: #ffffff;
  border: 2px solid #ff9900;
  border-radius: 10px;
  padding: 10px;
  color: #141414;
  font-weight: 700;
  font-size: 20px;
  text-align: center;
  box-shadow: 5px 5px 15px rgba(0, 0, 0, 0.1);
  cursor: pointer;
`;
