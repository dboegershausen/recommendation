package com.recommender.api.v1.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;

public class AccessoryRecommendationRequest {

    @Min(value = 1, message = "Distance not be less than 1")
    @ApiModelProperty(value = "Distância da pedalada", example = "20")
    private Integer distance;

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

}
