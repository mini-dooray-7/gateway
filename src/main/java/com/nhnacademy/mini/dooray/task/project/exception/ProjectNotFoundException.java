package com.nhnacademy.mini.dooray.task.project.exception;

import lombok.Getter;

@Getter
public class ProjectNotFoundException extends RuntimeException{
    private String message;

    public ProjectNotFoundException(Long id) {
        this.message = "Id : " + id +" is not found";
    }
}
