import React from 'react';
import styled from 'styled-components';

const DetailModal = () => {
    return (
        <DetailModalWrapper onClick={e => e.stopPropagation()}>
        
        </DetailModalWrapper>
    );
}
const Container = styled.div`
border: 1px solid red;
width: 300px;
height: 300px;
`;
const CheckBox = styled.div`
display: flex;
border: 1px solid red;
width: 100%;
/* border: 1px */
`;
const CheckIn = styled.div``;
const CheckOut = styled.div``;
const PersonnelBox = styled.div``;

const DetailModalWrapper = styled.div`

position: absolute;
width: 600px;
height: 600px;
border-radius: 50px;
top:30%;
left:40%;
background-color: white;
z-index: 3;
`;
export default DetailModal;
