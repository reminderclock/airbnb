import React, {useEffect} from 'react';
import styled from 'styled-components';
const { kakao } = window;
const dumyData = [
    {
        title: "숙소1",
        lat: 37.62197524055062,
        lng: 127.16017523675508,
        cost:105260,
      },
      {
        title: "숙소2",
        lat: 37.620842424005616,
        lng: 127.1583774403176,
        cost:95260,
      },
      {
        title: "숙소3",
        lat: 37.624915253753194,
        lng: 127.15122688059974,
        cost:135260,
      },
      {
        title: "숙소3",
        lat: 37.62456273069659,
        lng: 127.15211256646381,
        cost:155260,
      },

];
const MapBox = ({roomInfo}) => {
    console.log(roomInfo)
    const numToCash = (num) => {
        return num.toLocaleString( 'ko-KR', { style: 'currency', currency: 'KRW' } );
    } 
    useEffect(() => {
        if(roomInfo === null) return;
        mapscript();


        // let x = roomInfo.rooms.map(e => e.xPos);
        // let y = roomInfo.rooms.map(e => e.yPos)
        // console.log(x, y)
        // const container = document.getElementById('myMap');
		// const options = {
		// 	center: new kakao.maps.LatLng(33.450701, 126.570667),
		// 	level: 3
		// };
        // https://map.kakao.com/link/map/22.35364454353453,85.68975653434279
        // const map = new kakao.maps.Map(container, options);
    }, [roomInfo]);

    const mapscript = () => {
        let container = document.getElementById("myMap");
        let options = {
          center: new kakao.maps.LatLng(37.624915253753194, 127.15122688059974),
          level: 5,
        };
        //map
        const map = new kakao.maps.Map(container, options);
    
        //마커가 표시 될 위치
        // let markerPosition = new kakao.maps.LatLng(
        //   37.62197524055062,
        //   127.16017523675508
        // );
        dumyData.forEach((el => {
            const marker = new kakao.maps.Marker({
                map: map,
                title: el.title,
                position: new kakao.maps.LatLng(el.lat, el.lng),
            });
            let infowindow = new kakao.maps.InfoWindow({
                content: numToCash(el.cost), // 인포윈도우에 표시할 내용
              });
              infowindow.open(map, marker);
        }))


        // dumyData.forEach((el) => {
        //     new kakao.maps.InfoWindow({
        //         content: el.title
        //     })
        // })
        // 마커를 생성
        // let marker = new kakao.maps.Marker({
        //   position: markerPosition,
        // });
        // let infowindow = new kakao.maps.InfoWindow({
        //     content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
        // });
    
        // 마커를 지도 위에 표시
        // marker.setMap(map);
      };
    return (
        <MapBoxWrapper>
        <div id='myMap' style={{
            width: '100%', 
            height: '100%'
        }}></div>
        </MapBoxWrapper>
    );
}
const MapBoxWrapper = styled.div`
width:100%;
height: 90vh;
`;

export default MapBox;
