import React, {useState, useEffect, useRef, useContext} from 'react';
import styled from 'styled-components';
// import {Slider} from "@material-ui/core";
import axios from 'axios';
import { PostsContext } from '../searchBar/SearchBar';
import Slider from './Slider';

const PriceModal = () => {
  let min = 0;
  let max = 0;
  const {periodInfo, setPeriodInfo} = useContext(PostsContext);
  const [average, setAverage] = useState(0);
  const [minValue, setMin] = useState(0);
  const [maxValue, setMax] = useState(0);
  const [price, setPrice] = useState(null)
  const checkIn = periodInfo.filter(e => e.id === 1).map(e => e.input).join('');
  const checkOut = periodInfo.filter(e => e.id ===2).map(e => e.input).join('');
  const API_URL =`/rooms/charges?check-in=${checkIn}&check-out=${checkOut}`
  useEffect(() => {
    if(checkIn === "날짜입력" || checkOut === "날짜입력")return;
    console.log('api',API_URL);
    loadData();
  },[]);
  const loadData = () => {
    axios.get(API_URL).then((response) => {
      console.log(response.data);
      setValue(response.data.charges);
      // setAverage(response.data.average)
    })
  }
  const setValue = (chargeData) => {
    setPrice(chargeData)
    min = chargeData[0].charge;
    max = chargeData[chargeData.length-1].charge;
  }
    return (
        <PriceModalWrapper className="PriceModal" onClick={e => e.stopPropagation()}>
          {/* {findAverage(price)} */}
          <Slider price ={price} min={10000} max={14000}/>
        </PriceModalWrapper>
    );
}

const PriceModalWrapper = styled.div`
    position: absolute;
    width: 40%;
    height: 300px;
    border-radius: 50px;
    background-color: #cfcfac;
    top:120%;
    left:35%;
    color: green;
    padding: 50px;
  font-size: 16px;
`;

const PriceContainer = styled.div`
/* text-align: center; */
padding: 30px;
width: 70%;
`;
export default PriceModal;
