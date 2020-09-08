package com.recommender.domain.builder;

import com.recommender.domain.model.Bike;
import com.recommender.domain.model.BikeQuality;
import com.recommender.domain.model.BikeSize;
import com.recommender.domain.model.BikeType;

public final class BikeBuilder {

    private Bike bike;

    private BikeBuilder() {
        bike = new Bike();
    }

    public BikeBuilder withSize(BikeSize size) {
        bike.setSize(size);
        return this;
    }

    public BikeBuilder withQuality(BikeQuality quality) {
        bike.setQuality(quality);
        return this;
    }

    public BikeBuilder withType(BikeType type) {
        bike.setType(type);
        return this;
    }

    public static BikeBuilder of() {
        return new BikeBuilder();
    }

    public Bike build() {
        return bike;
    }

}
