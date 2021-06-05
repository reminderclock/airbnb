import React, { useContext} from 'react';
import styled from 'styled-components';
import PriceModal from '../modal/PriceModal';
import useComponentVisible from "../modal/Modal"
import { PostsContext } from '../searchBar/SearchBar';


const Price = () => {
    const {isCheck, minVal, maxVal} = useContext(PostsContext);
    const {ref, isComponentVisible, setIsComponentVisible} = useComponentVisible(true);
    const numToCash = (num) => {
        return num.toLocaleString( 'ko-KR', { style: 'decimal', deciam: 'KRW' } );
    } 
    return (
        <PriceWrapper ref={ref}>
            <PriceBtn  onClick={() => setIsComponentVisible(!isComponentVisible)}>
        <Title>요금</Title>
        <View>
        {!isCheck() && `금액대 설정`}
        {isCheck() && <PriceRange>
         <div>{numToCash(minVal)}</div>
         <div>~</div>
         <div>{numToCash(maxVal)}</div>   
        </PriceRange>}
        </View>
        {!isComponentVisible && <PriceModal/>}
        </PriceBtn>
        </PriceWrapper>
    );
}
const PriceRange = styled.div`
display: flex;
`;
const PriceWrapper = styled.div`
flex: auto;
`;
const PriceBtn = styled.div`
display: flex;
border-radius: 100px;
width: 100%;
flex-direction: column;
padding: 20px;
padding-left: 15%;
&:hover {
    background-color: #ebebeb;
}`;
const Title = styled.span`
padding: 5px 0;
display:block;
font-weight: 500;
font-size: 20px;
`;
const View = styled.span``;

export default Price;
