import styled from "styled-components";

export const Wrap = styled.div`
  position: sticky;
  width: 100%;
  max-width: 480px;
  top: 0;
  background-color: #ffffff;
`;

export const Title = styled.div`
  height: 60px;
  display: flex;
  align-items: center;
  justify-content: center;
  border-bottom: 3px solid #f1f1f5;
  font-weight: 600;
  font-size: 30px;
  text-align: center;
  > img {
    width: ${(props) => props.width};
    height: ${(props) => props.height};
    &:first-child {
      left: 20px;
      float: left;
      position: absolute;
    }
    &:last-child {
      right: 20px;
      float: right;
      position: absolute;
    }
  }
`;

export const FlexBox = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 10px;
  position: absolute;
  right: 10px;
  > img {
    width: ${(props) => props.width};
    height: ${(props) => props.height};
  }
`;
