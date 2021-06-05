package com.codesquad.team10.airbnb.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SignInDto {
    @JsonProperty
    private String userId;

    @JsonProperty
    private String password;

    @JsonProperty
    private String nickname;

    @JsonProperty
    private String email;

    public SignInDto(String userId, String password, String nickname, String email) {
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }

    @Override
    public String toString() {
        return "SignInDto{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
