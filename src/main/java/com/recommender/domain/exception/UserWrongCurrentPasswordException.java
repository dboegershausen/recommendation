package com.recommender.domain.exception;

public class UserWrongCurrentPasswordException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserWrongCurrentPasswordException() {
        super("Current user password not match");
    }

}
