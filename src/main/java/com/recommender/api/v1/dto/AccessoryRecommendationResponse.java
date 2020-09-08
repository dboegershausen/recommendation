package com.recommender.api.v1.dto;

import java.util.List;

public class AccessoryRecommendationResponse {

    private Long id;

    private List<String> accessories;

    private AccessoryInputResponse input;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccessoryInputResponse getInput() {
        return input;
    }

    public void setInput(AccessoryInputResponse input) {
        this.input = input;
    }

    public List<String> getAccessories() {
        return accessories;
    }

    public void setAccessories(List<String> accessories) {
        this.accessories = accessories;
    }
}
