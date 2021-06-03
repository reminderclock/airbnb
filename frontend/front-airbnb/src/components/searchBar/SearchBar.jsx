import React, { useState} from 'react';
import styled from 'styled-components';
import Period from './Period';
import Personnel from './Personnel';
import Price from './Price';
import SearchButton from './SearchButton';
import useComponentVisible from "../modal/Modal"

export const PostsContext = React.createContext();
const SearchBar = () => {
    const periodData = [
        {
            id: 1,
            name: '체크인',
            input: '날짜입력'
        },
        {
            id: 2,
            name: '체크아웃',
            input: '날짜입력'
        },
    ]
    const [periodInfo, setPeriodInfo] = useState(periodData);
    const [priceInfo, setPriceInfo] = useState(['금액대 설정']);
    const [personnelInfo, setPersonnelInfo] = useState('게스트 추가');
    const {searchRef, isFocus, setIsFocus} = useComponentVisible(true);
    const [minVal, setMinVal] = useState(10000);
    const [maxVal, setMaxVal] = useState(14000);
    const isCheck = () => {
        let newArr = [...periodInfo]
        if(newArr[0].input === '날짜입력' || newArr[1].input === '날짜입력') return false;
        else return true;
    }
    return (
        <PostsContext.Provider value={{personnelInfo, setPersonnelInfo, minVal, setMinVal, maxVal, setMaxVal, isCheck, periodInfo, setPeriodInfo, personnelInfo, setPersonnelInfo, priceInfo, setPriceInfo}}>
        <SearchBarWrapper ref={searchRef} onClick={() => setIsFocus(false)}>
            <Period/>
            <Price/>
            <Personnel/>
            <SearchButton setIsFocus={setIsFocus} isFocus={isFocus}/>
        </SearchBarWrapper>
        </PostsContext.Provider>
    );
}
const SearchBarWrapper = styled.div`
    border: 2px solid gray;
    position: relative;
    border-radius:100px;
    background:white;
    display:flex;
    margin: 2% 15%;
    align-items: center;
`;

export default SearchBar;
