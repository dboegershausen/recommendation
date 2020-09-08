package com.recommender.domain.model;

import java.util.Arrays;

public enum BikeSize {

    SMALL("Pequena") {
        @Override
        public boolean isIndicatedByHeight(Double height) {
            return height < 1.70;
        }
    }, MEDIUM("Média") {
        @Override
        public boolean isIndicatedByHeight(Double height) {
            return height >= 1.70 && height < 1.80;
        }
    }, BIG("Grande") {
        @Override
        public boolean isIndicatedByHeight(Double height) {
            return height >= 1.80;
        }
    };

    private String name;

    BikeSize(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract boolean isIndicatedByHeight(Double height);

    public static BikeSize getIndicatedByHeight(Double height) {
        return Arrays.asList(values()).stream()
                .filter(bikeSize -> bikeSize.isIndicatedByHeight(height))
                .findFirst().orElse(MEDIUM);
    }

}
