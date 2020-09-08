package com.recommender.domain.exception;

public class UserWrongCurrentPasswordException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserWrongCurrentPasswordException() {
        super(String.format("Current user password not match"));
    }

}
