import styled from "styled-components";

export const Wrap = styled.div`
  position: sticky;
  width: 100%;
  max-width: 480px;
  bottom: 0;
  background-color: #ffffff;
`;

export const Menu = styled.div`
  max-width: 480px%;
  height: 60px;
  display: grid;
  align-items: center;
  grid-template-columns: repeat(5, 1fr);
  border-top: 3px solid #f1f1f5;
`;

export const BtnLink = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  > img {
    width: 35px;
    cursor: pointer;
  }
`;
