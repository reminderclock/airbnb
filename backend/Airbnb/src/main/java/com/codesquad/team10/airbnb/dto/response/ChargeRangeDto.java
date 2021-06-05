package com.codesquad.team10.airbnb.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ChargeRangeDto {
    @JsonProperty
    private Integer average;

    @JsonProperty
    private List<ChargeGroupDto> charges;

    public ChargeRangeDto(Integer average, List<ChargeGroupDto> charges) {
        this.average = average;
        this.charges = charges;
    }
}
