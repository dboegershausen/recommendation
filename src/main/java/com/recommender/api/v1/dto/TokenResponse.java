package com.recommender.api.v1.dto;

public class TokenResponse {

    private String tokenType;
    private String token;

    public TokenResponse(String tokenType, String token) {
        this.tokenType = tokenType;
        this.token = token;
    }

}
