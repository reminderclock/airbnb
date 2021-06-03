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
    // useEffect(() => {
        
    //   },[roomInfo]);
    const loadData = () => {
        axios.get(API_URL).then((response) => {
            console.log(response.data.rooms.map(e=> e.location))
        setRoomInfo(response.data);
        // getData(response.data);
        })
    }

    // const periodList = periodInfo.map((e, idx) => {
    //     return <CheckBox key={idx}><Title>{e.name}</Title><View>{e.input}</View></CheckBox>
    // })
    return (
        <ResultPageWrapper>
            <ResultBox roomInfo={roomInfo}/>
            <MapBox/>
        </ResultPageWrapper>
    );
}

const ResultPageWrapper = styled.div`
position: absolute;
top:15%;
/* margin-top: 100px; */
display: flex;
justify-content: space-between;
`
export default ResultPage;
