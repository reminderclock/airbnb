import React, {useEffect, useState} from 'react';
import styled from 'styled-components';
import axios from 'axios';
import MapBox from "../resultPage/MapBox";
import ResultBox from '../resultPage/ResultBox';
import { FaStar, FaHeart } from "react-icons/fa";
const ResultPage = ({isMain}) => {
    const [roomInfo, setRoomInfo] = useState(null)
    const API_URL =`/rooms?location=서울&check-in=2021-05-10&check-out=2021-05-20&min=60000&max=90000&guests=4`
    useEffect(() => {
      loadData();
    },[isMain]);
    const loadData = () => {
        axios.get(API_URL).then((response) => {
            console.log(response.data.rooms.map(e=> e.location))
        setRoomInfo(response.data);
        })
    }
    return (
        <ResultPageWrapper>
            <ResultBox roomInfo={roomInfo}/>
            <MapBox roomInfo={roomInfo}/>
        </ResultPageWrapper>
    );
}

const ResultPageWrapper = styled.div`
/* position: absolute; */
z-index: -1;
top:15%;
width: 100%;
padding: 30px;
padding-top: 200px;
/* border: 2px solid red; */
display: flex;
justify-content: space-between;
`
export default ResultPage;
