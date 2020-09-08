package com.recommender.domain.builder;

import com.recommender.domain.model.*;

public final class BikeTypeCombinationBuilder {

    private BikeTypeCombination combination;

    private BikeTypeCombinationBuilder() {
        combination = new BikeTypeCombination();
    }

    public BikeTypeCombinationBuilder withObjective(ObjectiveType objective) {
        combination.setObjective(objective);
        return this;
    }

    public BikeTypeCombinationBuilder withGround(GroundType ground) {
        combination.setGround(ground);
        return this;
    }

    public static BikeTypeCombinationBuilder of() {
        return new BikeTypeCombinationBuilder();
    }

    public BikeTypeCombination build() {
        return combination;
    }

}
