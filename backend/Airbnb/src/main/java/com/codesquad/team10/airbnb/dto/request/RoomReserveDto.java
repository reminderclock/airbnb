package com.codesquad.team10.airbnb.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoomReserveDto {
    @JsonProperty
    private String userId;

    @JsonProperty
    private Integer roomId;

    @JsonProperty
    private String checkIn;

    @JsonProperty
    private String checkOut;

    @JsonProperty
    private Integer guests;

    public RoomReserveDto(String userId, Integer roomId, String checkIn, String checkOut, Integer guests) {
        this.userId = userId;
        this.roomId = roomId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.guests = guests;
    }

    @Override
    public String toString() {
        return "RoomReserveDto{" +
                "userId='" + userId + '\'' +
                ", roomId=" + roomId +
                ", checkIn='" + checkIn + '\'' +
                ", checkOut='" + checkOut + '\'' +
                ", guests=" + guests +
                '}';
    }
}
