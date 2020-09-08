package com.recommender.api.v1.dto;

import java.math.BigDecimal;
import java.util.List;

public class BikeInputResponse {

    private List<String> objectives;

    private List<String> grounds;

    private Integer monthDistance;

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
