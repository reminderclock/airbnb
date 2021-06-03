import React,{useState, useEffect} from 'react';
import SearchBar from '../searchBar/SearchBar';
import MenuBar from './header/MenuBar';
import styled from 'styled-components';

const Header = ({setIsMain, isMain, scrollY}) => {
console.log(scrollY>30)
    return (
        <HeaderBox>
        <HeaderWrapper scrollY={scrollY}>
            <MenuBar/>
            <SearchBarBox isMain={isMain} scrollY={scrollY}>
            <SearchBar setIsMain={setIsMain} isMain={isMain} scrollY={scrollY}/>
            </SearchBarBox>
        </HeaderWrapper>
        </HeaderBox>
    );
}
const HeaderBox = styled.div`
width: 100%;
position: fixed;
`;
const HeaderWrapper = styled.div`
position: relative;
border: 3px solid red;
padding: 50px 80px;
background-color: ${({scrollY})=> ((scrollY>20)? "white": "transparent")};

`;

const SearchBarBox = styled.div`
position: absolute;
top:${({scrollY, isMain})=> {
    if(scrollY > 20 || !isMain) return "0px";
    return "200px";
}};
width: 70%;
left:15%;
border: 1px solid blue;
`;

export default Header;
