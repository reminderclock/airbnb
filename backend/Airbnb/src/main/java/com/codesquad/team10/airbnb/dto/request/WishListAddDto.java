package com.codesquad.team10.airbnb.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WishListAddDto {
    @JsonProperty
    private Integer roomId;

    @JsonProperty
    private String userId;

    @JsonProperty
    private String accessToken;

    public WishListAddDto(Integer roomId, String userId, String accessToken) {
        this.roomId = roomId;
        this.userId = userId;
        this.accessToken = accessToken;
    }

    @Override
    public String toString() {
        return "WishListAddDto{" +
                "roomId=" + roomId +
                ", userId='" + userId + '\'' +
                ", accessToken='" + accessToken + '\'' +
                '}';
    }
}
