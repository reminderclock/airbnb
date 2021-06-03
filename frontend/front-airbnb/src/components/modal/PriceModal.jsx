import React, {useState, useEffect, useRef, useContext} from 'react';
import styled from 'styled-components';
import axios from 'axios';
import { PostsContext } from '../searchBar/SearchBar';
import Slider from './Slider';
import BarChart from './BarChart';

const PriceModal = () => {
  const {periodInfo} = useContext(PostsContext);
  const [price, setPrice] = useState(null)
  const [chartInfo, setChartInfo] = useState([[]]);
  const checkIn = periodInfo.filter(e => e.id === 1).map(e => e.input).join('');
  const checkOut = periodInfo.filter(e => e.id ===2).map(e => e.input).join('');
  const API_URL =`/rooms/charges?check-in=${checkIn}&check-out=${checkOut}`
  useEffect(() => {
    if(checkIn === "날짜입력" || checkOut === "날짜입력")return;
    loadData();
  },[]);
  const loadData = () => {
    axios.get(API_URL).then((response) => {
      setValue(response.data.charges);
    })
  }
  const setValue = (chargeData) => {
    setPrice(chargeData)
    setChartInfo(chargeData.map(e => [e.charge.toString(), e.count]));
  }
    return (
        <PriceModalWrapper className="PriceModal" onClick={e => e.stopPropagation()}>
         {(chartInfo[0][0] !== undefined) && <BarChart chartInfo ={chartInfo}/> }
          <Slider price ={price} min={10000} max={14000}/>
        </PriceModalWrapper>
    );
}

const PriceModalWrapper = styled.div`
    position: absolute;
    width: 50%;
    height: 400px;
    border-radius: 50px;
    background-color: white;
    top:120%;
    left:35%;
    /* color: green; */
    padding: 50px;
  font-size: 16px;
`;
 
export default PriceModal;
