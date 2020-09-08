package com.recommender.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class AccessoryRecommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<AccessoryType> accessories;

    @OneToOne(cascade = CascadeType.ALL)
    private AccessoryInput input;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<AccessoryType> getAccessories() {
        return accessories;
    }

    public void setAccessories(List<AccessoryType> accessories) {
        this.accessories = accessories;
    }

    public AccessoryInput getInput() {
        return input;
    }

    public void setInput(AccessoryInput input) {
        this.input = input;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
