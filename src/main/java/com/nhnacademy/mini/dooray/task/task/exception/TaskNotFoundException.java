package com.nhnacademy.mini.dooray.task.task.exception;

import lombok.Getter;

@Getter
public class TaskNotFoundException extends RuntimeException{
    private String message;

    public TaskNotFoundException(Long id) {
        this.message = "Id : " + id +" is not found";
    }
}
