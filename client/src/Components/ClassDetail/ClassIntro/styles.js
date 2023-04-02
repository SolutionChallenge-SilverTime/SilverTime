import styled from "styled-components";

export const Wrap = styled.div`
  padding: 20px 0;
  margin: 15px;
`;

export const ClassBlock = styled.div`
  margin-top: 5px;
  font-weight: 600;
  font-size: 23px;
  color: gray;
`;

export const BottomBlock = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  border-top: 1px solid #e0e0e0;
`;

export const ExplainBlock = styled.div`
  margin-top: 15px;
  padding-top: 10px;
  font-weight: 600;
  font-size: 24px;
`;

export const ImageBlock = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
`;

export const ImageTopBlock = styled.div`
  margin-top: 15px;
  display: flex;
  > img {
    width: 160px;
    height: 160px;
    border-radius: 30px;
  }
`;

export const ImageBottomBlock = styled.div`
  display: flex;
  > img {
    width: 160px;
    height: 160px;
    border-radius: 30px;
  }
`;
