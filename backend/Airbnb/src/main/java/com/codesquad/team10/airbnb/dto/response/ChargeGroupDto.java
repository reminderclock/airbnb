package com.codesquad.team10.airbnb.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChargeGroupDto {
    @JsonProperty
    private Integer charge;

    @JsonProperty
    private Integer count;

    public ChargeGroupDto(Integer charge, Integer count) {
        this.charge = charge;
        this.count = count;
    }
}
