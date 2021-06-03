import React,{useEffect, useState} from 'react';
import styled from 'styled-components';
import './App.css';
import Header from './components/mainPage/Header';
import Main from "./components/mainPage/Main"
function App() {
  const [scrollY, setScrollY] = useState(0);

  const logit = () => {
    setScrollY(window.pageYOffset);
  }
  console.log(scrollY)

  useEffect(() => {
    const watchScroll = () =>  {
      window.addEventListener("scroll", logit);
    }
    watchScroll();
    return () => {
      window.removeEventListener("scroll", logit);
    };
  });
  return (
  <AppWrapper>
  <Header scrollY={scrollY}/>
  <Main/>
  </AppWrapper>
  );
}

const AppWrapper = styled.div`
    width:100%;
    height:90vh;
    border: 0;
    background-image: url('https://a0.muscache.com/im/pictures/415fe2dc-98a1-4565-a702-70b03ae757d7.jpg?im_w=960');
    min-height: 100%;
    background-position: center;
    background-size: cover;
`;

export default App;
