import styled from "styled-components";

export const Wrap = styled.div`
  padding: 15px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  border: 1px solid #f1f1f5;
  > img {
    width: 70px;
    height: 70px;
    border-radius: 30px;
  }
`;

export const RightBlock = styled.div`
  display: flex;
  align-items: center;
  font-size: 18px;
  > span {
    margin-top: 5px;
    font-weight: 500;
  }
`;

export const InfoBlock = styled.div`
  margin-right: 50px;
  display: flex;
  flex-direction: column;
  font-weight: 800;
  font-size: 22px;
`;
