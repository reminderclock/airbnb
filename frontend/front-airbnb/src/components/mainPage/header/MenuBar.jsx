import React from 'react';
import styled from 'styled-components';
import Logo from './Logo';
import Menu from './Menu';
import MyPage from './MyPage';

const MenuBar = () => {
    return (
        <MenuBarWrapper>
            <Logo/>
            <Menu/>
            <MyPage/>
        </MenuBarWrapper>
    );
}

const MenuBarWrapper = styled.div`
    display:flex;
    justify-content:space-between;
    align-items:center;
`;

export default MenuBar;
