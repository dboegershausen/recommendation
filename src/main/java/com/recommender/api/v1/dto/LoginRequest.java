package com.recommender.api.v1.dto;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginRequest {

    @ApiModelProperty(example = "john.doe@gmail.com")
    private String email;

    @ApiModelProperty(example = "doe@123")
    private String password;

    public UsernamePasswordAuthenticationToken build() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }

}
