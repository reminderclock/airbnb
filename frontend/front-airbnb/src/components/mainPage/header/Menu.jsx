import React from 'react';
import styled from 'styled-components';

const Menu = () => {
    const MenuData = [
        {
            id: 1,
            name: '숙소',
        },
        {
            id: 2,
            name: '체험',
        },
        {
            id: 3,
            name: '온라인 체험',
        },
    ]
    const MenuLists = MenuData.map((menu,idx) => 
        <MenuList className={`List${idx}`}key={menu.id}>
        {menu.name}
        </MenuList>)
        
    return (
        <MenuWrapper>
            {MenuLists}
        </MenuWrapper>
    );
}

const MenuBtn = styled.button`
border: 0;
outline: 0;
font-size:30px;
background-color:transparent;
padding:0;
color: #828282;
&:hover {
    text-decoration:underline;
    color:black;
}
`;

const MenuList = styled.li`
border: 0;
outline: 0;
font-size:30px;
background-color:transparent;
padding:0;
color: #828282;
&:hover {
    text-decoration:underline;
    color:black;
}
&:nth-child(1) {
    text-decoration:underline;
    color:black;
}
padding: 0 20px;
    
`;
const MenuWrapper = styled.ul`
    display:flex;
    font-size:30px;
`;

export default Menu;
