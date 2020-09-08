package com.recommender.domain.model;

import javax.persistence.*;

@Entity
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BikeType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BikeQuality quality;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BikeSize size;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BikeType getType() {
        return type;
    }

    public void setType(BikeType type) {
        this.type = type;
    }

    public BikeQuality getQuality() {
        return quality;
    }

    public void setQuality(BikeQuality quality) {
        this.quality = quality;
    }

    public BikeSize getSize() {
        return size;
    }

    public void setSize(BikeSize size) {
        this.size = size;
    }
}
