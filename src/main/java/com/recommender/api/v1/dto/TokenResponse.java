package com.recommender.api.v1.dto;

import io.swagger.annotations.ApiModelProperty;

public class TokenResponse {

    private String tokenType;
    private String token;

    public TokenResponse(String tokenType, String token) {
        this.tokenType = tokenType;
        this.token = token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getToken() {
        return token;
    }
}
