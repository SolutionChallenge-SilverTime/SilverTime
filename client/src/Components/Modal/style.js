import styled from "styled-components";
import Modal from "styled-react-modal";

export const TypeModal = Modal.styled`
  padding:  20px;
  width: 70%;
  height: 70%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  border-radius: 20px;
  background-color: #E0E0E0;
  transition : all 0.3s ease-in-out;
  > span {
    font-size: 19px;
  }
`;

export const IconBlock = styled.div`
  margin: 15px 0;
  display: flex;
  align-items: center;
  > img {
    margin-right: 10px;
  }
  > span {
    margin-right: 20px;
    font-weight: 700;
    font-size: 20px;
  }
`;
