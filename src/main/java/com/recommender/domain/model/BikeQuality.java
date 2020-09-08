package com.recommender.domain.model;

import java.util.Arrays;

public enum BikeQuality {

    SIMPLE("Simples") {
        @Override
        public boolean isIndicatedByDistance(Integer distance) {
            return distance <= 100;
        }
    }, ITERMEDIARY("Intermediária") {
        @Override
        public boolean isIndicatedByDistance(Integer distance) {
            return distance > 100 && distance <= 200;
        }
    }, PROFESSIONAL("Profissional") {
        @Override
        public boolean isIndicatedByDistance(Integer distance) {
            return distance > 200;
        }
    };

    private String name;

    BikeQuality(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract boolean isIndicatedByDistance(Integer distance);

    public static BikeQuality getIndicatedTypeByDistance(Integer distance) {
        return Arrays.asList(values()).stream()
                .filter(bikeQuality -> bikeQuality.isIndicatedByDistance(distance))
                .findFirst().orElse(PROFESSIONAL);
    }

}
