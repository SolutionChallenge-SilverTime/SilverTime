import styled from "styled-components";

export const Wrap = styled.div`
  padding: 20px 20px 50px;
`;

export const DetailWrap = styled.div`
  > div {
    display: flex;
    align-items: center;
    padding: 20px;
    border: 1px solid #f1f1f5;
    height: 30px;
    font-size: 20px;
    &:last-child {
      height: 500px;
      align-items: flex-start;
    }
  }
`;

export const empty = styled.div`
  height: 100%;
`;
