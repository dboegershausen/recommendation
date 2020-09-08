package com.recommender.api.v1.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

public class BikeRecommendationRequest {

    @Size(min=1, message = "Objective must be informed")
    @ApiModelProperty(value = "Objetivos nos quais será utilizada a bicicleta", allowableValues = "CITY, TREK, CYCLING", example = "[\"CITY\"]")
    private List<String> objectives;

    @Size(min=1, message = "Ground must be informed")
    @ApiModelProperty(value = "Tipos de terreno nos quais será utilizada a bicicleta", allowableValues = "DIRT_ROAD, ROUGH_ROAD, NORMAL_ROAD", example = "[\"NORMAL_ROAD\"]")
    private List<String> grounds;

    @Min(value = 1, message = "Mount Distance not be less than 1")
    @ApiModelProperty(value = "Distância mensal que será utilizada a bicicleta", example = "100")
    private Integer monthDistance;

    @Min(value = 1, message = "Cyclist Height not be less than 1")
    @ApiModelProperty(value = "Tamanho do ciclista que utilizará a bicicleta", example = "1.75")
    private BigDecimal cyclistHeight;

    public List<String> getObjectives() {
        return objectives;
    }

    public void setObjectives(List<String> objectives) {
        this.objectives = objectives;
    }

    public List<String> getGrounds() {
        return grounds;
    }

    public void setGrounds(List<String> grounds) {
        this.grounds = grounds;
    }

    public Integer getMonthDistance() {
        return monthDistance;
    }

    public void setMonthDistance(Integer monthDistance) {
        this.monthDistance = monthDistance;
    }

    public BigDecimal getCyclistHeight() {
        return cyclistHeight;
    }

    public void setCyclistHeight(BigDecimal cyclistHeight) {
        this.cyclistHeight = cyclistHeight;
    }

}
