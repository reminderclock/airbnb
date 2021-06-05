package com.codesquad.team10.airbnb.controller;

import com.codesquad.team10.airbnb.dto.request.RoomReserveDto;
import com.codesquad.team10.airbnb.dto.request.WishListAddDto;
import com.codesquad.team10.airbnb.dto.response.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final Logger logger = LoggerFactory.getLogger(RoomController.class);

    @GetMapping("/charges")
    public ChargeRangeDto getChargeRange(@RequestParam("check-in") String checkIn, @RequestParam("check-out") String checkOut) {
        List<ChargeGroupDto> chargeGroups = new ArrayList<>();
        chargeGroups.add(new ChargeGroupDto(10000, 5));
        chargeGroups.add(new ChargeGroupDto(11000, 11));
        chargeGroups.add(new ChargeGroupDto(12000, 15));
        chargeGroups.add(new ChargeGroupDto(13000, 7));
        chargeGroups.add(new ChargeGroupDto(14000, 2));

        return new ChargeRangeDto(165556, chargeGroups);
    }

    @GetMapping
    public SearchResultDto getSearchResult(@RequestParam String location, @RequestParam("check-in") String checkIn, @RequestParam("check-out") String checkOut,
                                           @RequestParam Integer min, @RequestParam Integer max, @RequestParam Integer guests) {
        logger.debug(location + " " + checkIn + " " + checkOut + " " + min + " " + max + " " + guests);

        List<RoomDto> rooms = new ArrayList<>();
        rooms.add(new RoomDto("서울", "Spacious and Comfortable cozy house #4", "https://www.airbnb.com/rooms/29556662/photos/604588770?federated_search_id=6422bc81-ecb8-4381-a7b0-758e46144cbe&source_impression_id=p3_1621340285_vHikcFrealdXlffU&guests=1&adults=1",
                "35.97664845766847", "126.99597295767953", "최대 인원 3명 ・ 원룸 ・ 침대 1개 ・ 욕실 1개・ 주방 ・ 무선 인터넷・ 에어컨 ・ 헤어드라이어", 82953, 149159, 4.5, 272));
        rooms.add(new RoomDto("서울", "소소한 파티하기 좋은 숙소 / 홍대 / 연남동 / artist house3", "https://www.airbnb.com/rooms/29556662/photos/604588770?federated_search_id=6422bc81-ecb8-4381-a7b0-758e46144cbe&source_impression_id=p3_1621340285_vHikcFrealdXlffU&guests=1&adults=1",
                "22.35364454353453", "85.68975653434279", "최대 인원 3명 ・ 원룸 ・ 침대 2개 ・ 욕실 1개・ 주방 ・ 무선 인터넷・ 에어컨 ・ 헤어드라이어", 72300, 132123, 3.5, 301));
        rooms.add(new RoomDto("서울", "B) 3min from Itaewon Stn [ 2 BR ] Rooftop View", "https://www.airbnb.com/rooms/29556662/photos/604588770?federated_search_id=6422bc81-ecb8-4381-a7b0-758e46144cbe&source_impression_id=p3_1621340285_vHikcFrealdXlffU&guests=1&adults=1",
                "127.23254443432437", "110.23232353534342", "최대 인원 2명 ・ 원룸 ・ 침대 1개 ・ 욕실 2개・ 주방 ・ 무선 인터넷・ 에어컨 ・ 헤어드라이어", 64302, 123030, 4.2, 500));
        return new SearchResultDto(rooms.size(), rooms);
    }

    @GetMapping("/{id}/charges")
    public ChargeDetailDto getChargeDetail(@PathVariable Long id, @RequestParam String location, @RequestParam("check-in") String checkIn, @RequestParam("check-out") String checkOut, @RequestParam Integer guests) {
        logger.debug(location + " " + checkIn + " " + checkOut + " " + guests);
        return new ChargeDetailDto(1322395, 55948, 25996, 1822468, 18247, 67006);
    }

    @PostMapping("/reserve")
    @ResponseStatus(HttpStatus.CREATED)
    public void reserveRoom(@RequestBody RoomReserveDto roomReserveDto) {
        logger.debug(roomReserveDto.toString());
    }

    @PostMapping("/wishlists")
    @ResponseStatus(HttpStatus.CREATED)
    public void addToWishList(@RequestBody WishListAddDto wishListAddDto){
        logger.debug(wishListAddDto.toString());
    }
}
