import React,{useState, useEffect} from 'react';
import SearchBar from '../searchBar/SearchBar';
import MenuBar from './header/MenuBar';
import styled from 'styled-components';

const Header = ({scrollY}) => {
console.log(scrollY>30)
    return (
        <HeaderBox>
        <HeaderWrapper scrollY={scrollY}>
            <MenuBar/>
            <SearchBarBox scrollY={scrollY}>
            <SearchBar scrollY={scrollY}/>
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
top:${({scrollY})=> ((scrollY>20)? "0px": "200px")};
width: 70%;
left:15%;
border: 1px solid blue;
`;

export default Header;
