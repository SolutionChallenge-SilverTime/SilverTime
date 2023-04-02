import styled from "styled-components";

export const Wrap = styled.div`
  padding: 20px 20px 0;
`;

export const SpanBlock = styled.div`
  font-weight: ${(props) => props.textBold || 700};
  font-size: ${(props) => props.fonSize || "20px"};
`;

export const NameBlock = styled.div`
  margin: 20px 0;
  font-weight: 700;
  font-size: 24px;
`;

export const DetailBlock = styled.div`
  > span {
    margin-right: 20px;
    font-weight: 700;
    font-size: 20px;
    &:first-child {
      color: #ff7f00;
    }
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

export const BottomBlock = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
`;

export const ContentBlock = styled.div`
  border-top: 2px solid #e0e0e0;
`;

export const NavigateBlock = styled.div`
  display: flex;
  justify-content: space-between;
`;
