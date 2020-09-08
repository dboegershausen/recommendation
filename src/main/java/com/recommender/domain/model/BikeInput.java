package com.recommender.domain.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class BikeInput {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<String> objectives;

    @ElementCollection
    private List<String> grounds;

    private Integer monthDistance;

    private BigDecimal cyclistHeight;

    @OneToOne(mappedBy = "input")
    private BikeRecommendation recommendation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getObjectives() {
        return objectives;
    }

    public void setObjectives(List<String> objectives) {
        this.objectives = objectives;
    }

    public List<String> getGrounds() {
        return grounds;
    }

    public void setGrounds(List<String> grounds) {
        this.grounds = grounds;
    }

    public Integer getMonthDistance() {
        return monthDistance;
    }

    public void setMonthDistance(Integer monthDistance) {
        this.monthDistance = monthDistance;
    }

    public BigDecimal getCyclistHeight() {
        return cyclistHeight;
    }

    public void setCyclistHeight(BigDecimal cyclistHeight) {
        this.cyclistHeight = cyclistHeight;
    }

}
