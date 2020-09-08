package com.recommender.domain.model;

import java.util.Objects;

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BikeTypeCombination that = (BikeTypeCombination) o;
        return objective == that.objective &&
                ground == that.ground;
    }

    @Override
    public int hashCode() {
        return Objects.hash(objective, ground);
    }

    @Override
    public String toString() {
        return "BikeTypeCombination{" +
                "objective=" + objective +
                ", ground=" + ground +
                '}';
    }

}
