package com.nhnacademy.mini.dooray.task.comment.exception;

import lombok.Getter;

@Getter
public class CommentNotFoundException extends RuntimeException{
    private String message;

    public CommentNotFoundException(Long id) {
        this.message = "commentId : " + id +" is not found";
    }
}
