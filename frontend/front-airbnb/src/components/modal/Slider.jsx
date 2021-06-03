import styled from 'styled-components';
import React, { useCallback, useEffect, useState, useRef, useContext } from "react";
import { PostsContext } from '../searchBar/SearchBar';

const Slider = ({price, min, max}) => {
  const { minVal, setMinVal, maxVal, setMaxVal, isCheck, periodInfo, setPeriodInfo} = useContext(PostsContext);

    const minValRef = useRef(min);
    const maxValRef = useRef(max);
    const range = useRef(null);
  // const isCheck = () => {
  //   let newArr = [...periodInfo]
  //   if(newArr[0].input === '날짜입력' || newArr[1].input === '날짜입력') return false;
  //   else return true;
  // }
    // Convert to percentage
    const getPercent = useCallback(
      (value) => Math.round(((value - min) / (max - min)) * 100),
      [min, max]
    );
  
    // Set width of the range to decrease from the left side
    useEffect(() => {
      const minPercent = getPercent(minVal);
      const maxPercent = getPercent(maxValRef.current);
  
      if (range.current) {
        range.current.style.left = `${minPercent}%`;
        range.current.style.width = `${maxPercent - minPercent}%`;
      }
    }, [minVal, getPercent]);
  
    // Set width of the range to decrease from the right side
    useEffect(() => {
      const minPercent = getPercent(minValRef.current);
      const maxPercent = getPercent(maxVal);
  
      if (range.current) {
        range.current.style.width = `${maxPercent - minPercent}%`;
      }
    }, [maxVal, getPercent]);
    const getMinValue = (event) => {
        console.log(event.target.value)
        const value = Math.min(Number(event.target.value), maxVal - 1);
        setMinVal(value);
        minValRef.current = value;
    }
    const getMaxValue = (event) => {
        const value = Math.max(Number(event.target.value), minVal + 1);
        setMaxVal(value);
        maxValRef.current = value;
    }
    const numToCash = (num) => {
        return num.toLocaleString( 'ko-KR', { style: 'currency', currency: 'KRW' } );
    } 
    const findAverage = (data) => {
        console.log(data)
        if(data === null) return;
        let lineValue = data.filter(e => e.charge >= minVal && e.charge <= maxVal).map(e => e.charge*e.count).reduce((prev,curr) => prev+curr);
        let cnt = data.filter(e => e.charge >= minVal && e.charge <= maxVal).map(e => e.count).reduce((prev, curr) => prev+curr);
        return createAverageString(Math.floor(lineValue/cnt));
      }
    const createAverageString = (data) => {
      return `평균1박 요금은 ${numToCash(data)}입니다.`;
    }
    return (
      <SliderContainer>
        {!isCheck() && <NoticeTitle>기간설정을 해주세요!</NoticeTitle>}
        {  isCheck() && <div>
          <ValueWrapper>
            <PriceTitle>{`가격범위`}</PriceTitle>
            <SliderValue>
          <SliderLeftValue>{`${numToCash(minVal)}-`}</SliderLeftValue>
          <SliderRightValue>{`${numToCash(maxVal)}+`}</SliderRightValue>
          </SliderValue>
          <PriceAverage>{findAverage(price)}</PriceAverage>
          </ValueWrapper>
        <InputLeft
          type="range"
          min={min}
          max={max}
          value={minVal}
          onChange={(event) => getMinValue(event)}
          style={{ zIndex: minVal > max - 100 && "5" }}
        />
        <InputRight
          type="range"
          min={min}
          max={max}
          value={maxVal}
          onChange={(event) => getMaxValue(event)}
        />
        <RealSlider>
          <SliderTrack />
          <SliderRange ref={range} />
        </RealSlider>
        </div>}
      </SliderContainer>
    );
}
const NoticeTitle = styled.div`
position: absolute;
top:40px;
color: black;
font-weight: 600;
font-size : 25px;
`;
const PriceTitle = styled.div`
color: black;
font-weight: 600;
font-size : 25px;
`;
const SliderValue = styled.div`
display: flex;
margin-bottom: 10px;
`;
const PriceAverage = styled.div`
color: gray;
`;
const ValueWrapper = styled.div`
display: flex;
flex-direction: column;
position: absolute;
top: 10%;
left: 10%; 
`;
const Input = styled.input`
  -webkit-appearance: none;
  pointer-events: none;
  /* top: 20%; */
  position: absolute;
  height: 0;
  width: 400px;
  outline: none;
  &::-webkit-slider-thumb {
    -webkit-appearance: none;
  background-color: #f1f5f7;
  border: none;
  border-radius: 50%;
  box-shadow: 0 0 1px 1px #ced4da;
  cursor: pointer;
  height: 18px;
  width: 18px;
  margin-top: 4px;
  pointer-events: all;
  position: relative;
}
`;
const InputLeft = styled(Input)`
  z-index: 6;
  background-color: white;
`;
const InputRight = styled(Input)`
  z-index: 7;
`;

const RealSlider = styled.div`
  position: relative;
  width: 400px;
  z-index: 2;
`;

const AbsoluteBox = styled.div`
  position: absolute;
  /* top:-20px; */
  /* border: 1px solid red; */
`;
const SliderTrack = styled(AbsoluteBox)`
  border-radius: 3px;
  height: 5px;
  background-color: #ced4da;
  width: 80%;
  z-index: 4;
`;
const SliderRange = styled(AbsoluteBox)`
  border-radius: 3px;
  height: 5px;
  background-color: #9fe5e1;
  z-index: 5;
  /* left: 30%; */
  `;

const direaction = styled.div`
  /* position: absolute; */
  color: black;
  font-size: 20px;
  margin-top: 20px;
`;
const SliderLeftValue = styled(direaction)`
 margin-right: 10px;
  left: 6px;
`;
const SliderRightValue = styled(direaction)`
  right: -4px;
`;

const SliderContainer = styled.div`
  height: 30vh;
  /* width: 100%; */
  display: flex;
  align-items: center;
  justify-content: center;
`;
export default Slider;
