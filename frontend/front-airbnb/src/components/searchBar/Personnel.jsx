import React, { useContext, useReducer } from 'react';
import styled from 'styled-components';
import PersonnelModal from '../modal/PersonnelModal';
import useComponentVisible from "../modal/Modal"
import { PostsContext } from './SearchBar'; 

const Personnel = () => {
    const {personnelInfo, setpersonnelInfo} = useContext(PostsContext);
    const {ref, isComponentVisible, setIsComponentVisible} = useComponentVisible(true);
    return (
        <PersonnelWrapper ref={ref}>
            <PersonnelBtn onClick={() => setIsComponentVisible(!isComponentVisible)}>
                <CheckBox>
                    <Title>인원</Title>
                    <View>{personnelInfo}</View>
                </CheckBox>
                {!isComponentVisible && <PersonnelModal/>}
            </PersonnelBtn>
        </PersonnelWrapper>
    );
}


const PersonnelWrapper = styled.div`
flex: auto;
`;
const PersonnelBtn = styled.div`
display:flex;
border-radius: 100px;
width: 100%;
height: auto;
padding: 20px;
padding-left: 15%;
&:hover {
    background-color: #ebebeb;
}
`

const Title = styled.span`
padding: 5px 0;
display:block;
font-weight: 500;
font-size: 20px;
`;
const View = styled.span``;

const CheckBox = styled.div`
margin-right:10%
`;

export default Personnel;
