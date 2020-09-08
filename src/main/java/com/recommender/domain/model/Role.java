package com.recommender.domain.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role implements GrantedAuthority {

    @Id
    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }
}
