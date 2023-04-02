import styled from "styled-components";

export const Wrap = styled.div`
  padding: 20px;
  display: flex;
  border: 1px solid #f1f1f5;
  > img {
    width: 50px;
    height: 50px;
    border-radius: 30px;
  }
`;

export const RightBlock = styled.div`
  margin-left: 25px;
  display: flex;
  flex-direction: column;
  font-size: 18px;
  > span {
    margin-top: 5px;
    font-weight: 500;
  }
`;

export const NameBlock = styled.div`
  display: flex;
  gap: 15px;
  font-weight: 800;
  font-size: 20px;
  > span {
    &:first-child {
      color: "#141414";
      font-weight: 650;
    }
  }
`;

export const TopBlock = styled.div`
  display: flex;
  gap: 10px;
  font-size: 16px;
  > span {
    position: absolute;
    right: 20px;
  }
`;