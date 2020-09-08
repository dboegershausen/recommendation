package com.recommender.api.v1.dto;

public class BikeRecommendationResponse {

    private Long id;

    private BikeResponse bike;

    private BikeInputResponse input;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BikeResponse getBike() {
        return bike;
    }

    public void setBike(BikeResponse bike) {
        this.bike = bike;
    }

    public BikeInputResponse getInput() {
        return input;
    }

    public void setInput(BikeInputResponse input) {
        this.input = input;
    }

}
