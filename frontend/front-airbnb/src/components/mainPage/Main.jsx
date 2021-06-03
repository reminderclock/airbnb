import React from 'react';
import styled from 'styled-components';
import Header from './header/Header';
import SearchBar from '../searchBar/SearchBar';
const Main = () => {
    return (
        <MainWrapper>
            <Header/>
            <SearchBar/>
        </MainWrapper>
    );
}

const MainWrapper = styled.div`
    width:100%;
    height:90vh;
    border: 0;
    padding: 80px; 
    background-image: url('https://a0.muscache.com/im/pictures/415fe2dc-98a1-4565-a702-70b03ae757d7.jpg?im_w=960');
    min-height: 100%;
    background-position: center;
    background-size: cover;
`;

export default Main;
