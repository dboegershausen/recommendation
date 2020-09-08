package com.recommender.domain.model;

import com.recommender.domain.builder.BikeTypeCombinationBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum BikeType {

    LIFESTYLE("Urbana") {
        @Override
        public List<GroundType> getIndicatedGrounds() {
            return Arrays.asList(GroundType.NORMAL_ROAD,
                    GroundType.ROUGH_ROAD);
        }

        @Override
        public List<ObjectiveType> getIndicatedObjectives() {
            return Arrays.asList(ObjectiveType.CITY);
        }

    },
    MOUNTAIN("Mountain Bike") {
        @Override
        public List<GroundType> getIndicatedGrounds() {
            return Arrays.asList(GroundType.DIRT_ROAD,
                    GroundType.ROUGH_ROAD,
                    GroundType.NORMAL_ROAD);
        }

        @Override
        public List<ObjectiveType> getIndicatedObjectives() {
            return Arrays.asList(ObjectiveType.CITY,
                    ObjectiveType.TREK);
        }
    },
    ROAD("Speed") {
        @Override
        public List<GroundType> getIndicatedGrounds() {
            return Arrays.asList(GroundType.NORMAL_ROAD);
        }

        @Override
        public List<ObjectiveType> getIndicatedObjectives() {
            return Arrays.asList(ObjectiveType.CYCLING);
        }
    };

    private String name;

    private List<GroundType> indicatedGrounds;

    private List<ObjectiveType> indicatedObjectives;

    BikeType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract List<GroundType> getIndicatedGrounds();

    public abstract List<ObjectiveType> getIndicatedObjectives();

    public List<BikeTypeCombination> getPossibleCombinations() {
        List<BikeTypeCombination> combinations = new ArrayList<BikeTypeCombination>();
        List<ObjectiveType> objectives = getIndicatedObjectives();
        List<GroundType> grounds = getIndicatedGrounds();
        for (ObjectiveType objective : objectives) {
            for (GroundType ground : grounds) {
                combinations.add(BikeTypeCombinationBuilder.of()
                        .withObjective(objective)
                        .withGround(ground).build());
            }
        }
        return combinations;
    }

    public boolean isIndicatedByAllCombinations(List<BikeTypeCombination> combinations) {
        List<BikeTypeCombination> possibleCombinations = getPossibleCombinations();
        for (BikeTypeCombination combination : combinations) {
            if (!possibleCombinations.contains(combination)) {
                return false;
            }
        }
        return true;
    }

    public static BikeType getIndicatedTypeByCombinations(List<BikeTypeCombination> combinations) {
        return Arrays.asList(values()).stream()
                .filter(bikeType -> bikeType.isIndicatedByAllCombinations(combinations))
                .findFirst().orElse(MOUNTAIN);
    }

}
