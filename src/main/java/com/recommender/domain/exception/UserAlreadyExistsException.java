package com.recommender.domain.exception;

public class UserAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserAlreadyExistsException(String email) {
        super(String.format("User with email %s already exists", email));
    }

}
