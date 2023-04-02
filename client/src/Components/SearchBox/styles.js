import styled from "styled-components";

export const Wrap = styled.div`
    padding: 10px 20px;
    display: flex;
    justify-content: center;
    background: ${(props) => props.backgroundColor};
    border-radius: 17px;
    color: #7A7171;
    box-shadow: 5px 5px 15px rgba(0, 0, 0, 0.1);
    cursor: pointer;
`;