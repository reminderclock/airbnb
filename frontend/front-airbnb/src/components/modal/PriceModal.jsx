import React, {useState, useEffect, useRef} from 'react';
import styled from 'styled-components';
import {Slider} from "@material-ui/core";
import axios from 'axios';

const PriceModal = () => {
    const gfg = [
        {
          value: 0,
          label: "0",
        },
        {
          value: 100,
          label: "100",
        },
      ];
      const [val, setVal] = useState([0, 100]);
      const updateRange = (e, data) => {
        setVal(data);
      };
      const [range, setRange] = useState(null);
      const API_URL ='/rooms/charges?check-in="2021-05-10"&check-out="2021-05-20"'
      useEffect(() => {
        loadData();
      },[]);
      const loadData = () => {
        axios.get(API_URL).then((response) => {
          setValue(response.data.charges);
          setAverage(response.data.average)
        })
      }
      const [average, SetAverage] = useState(0);
      const setAverage = (average) => {
        SetAverage(average);
      }
      const setValue = (chargeData) => {
        setRange(chargeData);
        setVal([chargeData[0].charge, chargeData[chargeData.length-1].charge]);
      }
    return (
        <PriceModalWrapper className="PriceModal" onClick={e => e.stopPropagation()}>
            <PriceContainer>
                <span> 가격범위 </span>
                {val.map(e => <div>{e}</div>)}
                <div>{`평균 1박 요금은 ₩${average}입니다.`}</div>
                <Slider value={val} onChange={updateRange} marks={gfg} />
            </PriceContainer>{" "}
        </PriceModalWrapper>
    );
}

const PriceModalWrapper = styled.div`
    position: absolute;
    width: 70%;
    height: 300px;
    border-radius: 50px;
    background-color: #cfcfac;
    top:120%;
    left:20%;
    color: green;
  font-size: 16px;
`;

const PriceContainer = styled.div`
/* text-align: center; */
padding: 30px;
width: 70%;
`;
export default PriceModal;
