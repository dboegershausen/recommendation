package com.recommender.domain.model;

public class BikeTypeCombination {

    private ObjectiveType objective;

    private GroundType ground;

    public void setObjective(ObjectiveType objective) {
        this.objective = objective;
    }

    public void setGround(GroundType ground) {
        this.ground = ground;
    }

    @Override
    public boolean equals(Object o) {
        BikeTypeCombination that = (BikeTypeCombination) o;
        return objective.equals(that.objective) &&
                ground.equals(that.ground);
    }

}
