package com.recommender.api.v1.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

public class UserRequest {

    @NotEmpty(message = "Email must be informed")
    @ApiModelProperty(example = "john.doe@gmail.com")
    private String email;

    @NotEmpty(message = "Password must be informed")
    @ApiModelProperty(example = "doe@123")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
