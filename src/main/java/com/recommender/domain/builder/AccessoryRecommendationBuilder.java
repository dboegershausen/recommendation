package com.recommender.domain.builder;

import com.recommender.domain.model.*;

import java.util.List;

public final class AccessoryRecommendationBuilder {

    private AccessoryRecommendation recommendation;

    private AccessoryRecommendationBuilder() {
        recommendation = new AccessoryRecommendation();
    }

    public AccessoryRecommendationBuilder withAccessories(List<AccessoryType> accessories) {
        recommendation.setAccessories(accessories);
        return this;
    }

    public AccessoryRecommendationBuilder withInput(AccessoryInput input) {
        recommendation.setInput(input);
        return this;
    }

    public AccessoryRecommendationBuilder withUser(User user) {
        recommendation.setUser(user);
        return this;
    }

    public static AccessoryRecommendationBuilder of() {
        return new AccessoryRecommendationBuilder();
    }

    public AccessoryRecommendation build() {
        return recommendation;
    }

}
