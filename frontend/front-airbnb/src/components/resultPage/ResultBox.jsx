import React from 'react';
import styled from 'styled-components';
import { FaStar, FaHeart } from "react-icons/fa";
import DetailModal from './DetailModal';
import useComponentVisible from "../modal/Modal"
import imgA from "../../img/ex1.jpg"

const ResultBox = ({roomInfo}) => {
    const {ref, isComponentVisible, setIsComponentVisible} = useComponentVisible(true);
    const getData = () => {
        if(roomInfo === null) return;
        console.log(roomInfo)
        const list = roomInfo.rooms.map(e => {
            return <EachContainer>
                <ImgInfo>
                <img src={require('../../img/ex1.jpg')} width="200" height="200" alt="" />
                </ImgInfo>
                <TextInfo>
                <div>{e.location}</div>
                <div>{e.description}</div>
                <div>{e.title}</div>
                <div>{e.charge}</div>
                <div>{e.totalCharge}</div>
                <div><FaStar/>{e.ratings}</div>
                <div>{e.reviews}</div>
                <Heart><FaHeart/></Heart>
                </TextInfo>
            </EachContainer>
        })
        return list;
    }

    const total = () => {
        if(roomInfo === null) return;
        const totalCnt = roomInfo.total;
        return totalCnt;
    }
    return (
        <ResultBoxWrapper ref={ref}>
            <Title>{`지도에서 선택한 지역숙소(${total()}개)`}</Title>
            <Content onClick={() => setIsComponentVisible(!isComponentVisible)}>
                <Info>
        {getData()}
        </Info>
        {!isComponentVisible && <DetailModal/>}
        </Content>
        </ResultBoxWrapper> 
    );
}
const Heart = styled.div`
`;
const Content = styled.div``;
const Info = styled.div``;
const EachContainer = styled.div`
display: flex;
margin:10px;
border: 2px solid gray;
padding: 10px;
`;
const Title = styled.div`
margin-top: 20px;
font-size:30px;
font-weight:700;
`;
const ImgInfo = styled.div`
width: 300px;
height: auto;
`;
const TextInfo = styled.div`
margin-left: 20px;
`;
const ResultBoxWrapper = styled.div`
padding: 30px;
/* border: 1px solid red; */
width: 100%;
height: auto;
`;

export default ResultBox;
