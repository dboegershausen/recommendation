package com.recommender.domain.builder;

import com.recommender.domain.model.*;

public final class BikeRecommendationBuilder {

    private BikeRecommendation recommendation;

    private BikeRecommendationBuilder() {
        recommendation = new BikeRecommendation();
    }

    public BikeRecommendationBuilder withBike(Bike bike) {
        recommendation.setBike(bike);
        return this;
    }

    public BikeRecommendationBuilder withInput(BikeInput input) {
        recommendation.setInput(input);
        return this;
    }

    public BikeRecommendationBuilder withUser(User user) {
        recommendation.setUser(user);
        return this;
    }

    public static BikeRecommendationBuilder of() {
        return new BikeRecommendationBuilder();
    }

    public BikeRecommendation build() {
        return recommendation;
    }

}
