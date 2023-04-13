package com.projectstreamer.moviesservice.exception.exceptions;

public class CustomNotFoundException extends RuntimeException{
    public CustomNotFoundException(String message) {
        super(message);
    }
}
