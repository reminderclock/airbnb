package com.codesquad.team10.airbnb.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChargeDetailDto {
    @JsonProperty
    private Integer totalCharge;

    @JsonProperty
    private Integer discount;

    @JsonProperty
    private Integer cleaningFee;

    @JsonProperty
    private Integer serviceFee;

    @JsonProperty
    private Integer taxFee;

    @JsonProperty
    private Integer resultCharge;

    public ChargeDetailDto(Integer totalCharge, Integer discount, Integer cleaningFee, Integer serviceFee, Integer taxFee, Integer resultCharge) {
        this.totalCharge = totalCharge;
        this.discount = discount;
        this.cleaningFee = cleaningFee;
        this.serviceFee = serviceFee;
        this.taxFee = taxFee;
        this.resultCharge = resultCharge;
    }
}
