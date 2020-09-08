package com.recommender.domain.model;

import javax.persistence.*;

@Entity
public class AccessoryInput {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer distance;

    @OneToOne(mappedBy = "input")
    private AccessoryRecommendation recommendation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

}
