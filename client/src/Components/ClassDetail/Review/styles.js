import styled from "styled-components";

export const ReviewBlock = styled.div`
  padding: 20px 0;
  display: flex;
  align-items: center;
`;

export const SpanBlock = styled.div`
  font-weight: 500;
  font-size: 20px;
  > span {
    &:first-child {
      margin-right: 30px;
    }
  }
`;
