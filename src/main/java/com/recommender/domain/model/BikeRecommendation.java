package com.recommender.domain.model;

import javax.persistence.*;

@Entity
public class BikeRecommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private Bike bike;

    @OneToOne(cascade = CascadeType.ALL)
    private BikeInput input;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private User user;

    public Long getId() {
        return id;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public BikeInput getInput() {
        return input;
    }

    public void setInput(BikeInput input) {
        this.input = input;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
