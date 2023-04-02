import styled from "styled-components";

export const Wrap = styled.div`
  width: ${(props) => props.width || "120px"};
`;

export const DropdownTitle = styled.div`
  font-weight: 600;
  font-size: 16px;
  color: #141414;
`;

export const DropdownContainer = styled.div`
  height: 50px;
  background-color: ${(props) => props.backgroundColor || "#ff7f00"};
  position: relative;
  border-radius: 10px;
  padding: 12px 15px;
  font-weight: 400;
  font-size: 30px;
`;

export const DropdownInput = styled.div`
  padding: 5px;
  display: flex;
  align-items: center;
  justify-content: center;
  font-weight: 500;
`;

export const DropdownMenu = styled.div`
  margin-top: 5px;
  border: 1px solid #e0e0e0;
  border-radius: 10px;
  overflow: auto;
  max-height: 300px;
  text-align: center;
`;

export const DropdownItem = styled.div`
  border-bottom: 1px solid #e0e0e0;
  padding: 5px;
  font-size: 30px;
  cursor: pointer;
  &:hover {
    background-color: #ffb800;
  }
`;
