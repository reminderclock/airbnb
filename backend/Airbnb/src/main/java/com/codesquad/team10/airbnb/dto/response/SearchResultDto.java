package com.codesquad.team10.airbnb.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SearchResultDto {
    @JsonProperty
    private Integer total;

    @JsonProperty
    private List<RoomDto> rooms;

    public SearchResultDto(Integer total, List<RoomDto> rooms) {
        this.total = total;
        this.rooms = rooms;
    }
}
