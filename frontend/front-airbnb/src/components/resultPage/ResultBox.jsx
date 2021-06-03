import React from 'react';
import styled from 'styled-components';
import { FaStar, FaHeart } from "react-icons/fa";
const ResultBox = ({roomInfo}) => {
    const getData = () => {
        if(roomInfo === null) return;
        console.log(roomInfo)
        const list = roomInfo.rooms.map(e => {
            return <EachContainer>
                <ImgInfo>
                <img src={e.image} alt="" />
                </ImgInfo>
                <TextInfo>
                <div>{e.location}</div>
                <div>{e.description}</div>
                <div>{e.title}</div>
                <div>{e.charge}</div>
                <div>{e.totalCharge}</div>
                <div><FaStar/>{e.ratings}</div>
                <div>{e.reviews}</div>
                <div><FaHeart/></div>
                </TextInfo>
            </EachContainer>
        })
        return list;
    }
    return (
        <ResultBoxWrapper>
        {getData()}
        </ResultBoxWrapper> 
    );
}
const EachContainer = styled.div`
display: flex;
margin:10px;
border: 2px solid gray;
padding: 10px;
`;

const ImgInfo = styled.div`
width: 300px;
height: auto;
background-color: blue;
`;
const TextInfo = styled.div`
margin-left: 20px;
`;
const ResultBoxWrapper = styled.div`
border: 1px solid red;
/* width: 100px; */
height: 50px;
`;

export default ResultBox;
