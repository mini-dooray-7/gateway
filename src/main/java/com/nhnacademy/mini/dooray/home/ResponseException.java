package com.nhnacademy.mini.dooray.home;

import org.springframework.http.ResponseEntity;

public class ResponseException extends RuntimeException{
    private String message;
    ResponseEntity responseEntity;

    public ResponseException(String message, ResponseEntity response) {
        super(message);
        this.responseEntity = response;
    }
}
