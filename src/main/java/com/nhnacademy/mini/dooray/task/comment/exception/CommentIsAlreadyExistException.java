package com.nhnacademy.mini.dooray.task.comment.exception;

import lombok.Getter;

@Getter
public class CommentIsAlreadyExistException extends RuntimeException{
    private String message;

    public CommentIsAlreadyExistException(Long id) {
        this.message = "commentId : " + id +" is already exist";
    }
}
