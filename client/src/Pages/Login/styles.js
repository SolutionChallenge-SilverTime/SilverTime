import styled from "styled-components";

export const Wrap = styled.div`
    padding: 60px 20px 0;
`;

export const LogoBlock = styled.div`
    margin: 40px;
    display: flex;
    justify-content: center;
    > img {
        width: 200px;
        height: 200px;
    }
`;

export const InputBlock = styled.div`
    > div {
        &:first-child {
            display: flex;
            flex-direction: column;
            gap: 12px;
            margin-bottom: 18px;
        }
    }
`;

export const ButtonBlock = styled.div`
    margin-top: 60px;
    display: flex;
    flex-direction: column;
    gap: 12px;
`;

export const TypeButtonBlock = styled.div`
    display: flex;
    flex-direction: row;
    gap: 12px;
`;