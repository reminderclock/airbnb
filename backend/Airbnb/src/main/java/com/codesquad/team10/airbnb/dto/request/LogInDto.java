package com.codesquad.team10.airbnb.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LogInDto {
    @JsonProperty
    private String userId;

    @JsonProperty
    private String password;

    public LogInDto(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    @Override
    public String toString() {
        return "LogInDto{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
