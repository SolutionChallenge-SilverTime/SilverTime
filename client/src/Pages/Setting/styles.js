import styled from "styled-components";

export const TitleBlock = styled.div`
  padding: 16px 20px;
  border-top: 2px solid #e0e0e0;
  background-color: #ffffff;
  font-weight: 600;
  font-size: 24px;
`;

export const ItemBlock = styled.div`
  padding: 19px 20px;
  display: flex;
  justify-content: space-between;
  border-top: 0.5px solid #e0e0e0;
  background-color: #ffffff;
  font-size: 20px;
  cursor: pointer;
  > div {
    display: flex;
    align-items: center;
  }
  > span {
    color: #7c7c7c;
  }
`;

export const MySwitch = styled.div`
  position: relative;
  width: 50px;
  height: 24px;
  border: 2px solid ${(props) => (props.mySwitch ? "#ff7f00" : "#7C7C7C")};
  border-radius: 15px;
  > div {
    transition: all 0.5s ease;
    border-radius: 70%;
    background-color: ${(props) => (props.mySwitch ? "#ff7f00" : "#7C7C7C")};
    width: 18px;
    height: 18px;
    position: absolute;
    right: ${(props) => (props.mySwitch ? "4px" : "28px")};
  }
`;
