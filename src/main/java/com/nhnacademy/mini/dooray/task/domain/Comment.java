package com.nhnacademy.mini.dooray.task.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Long commentId;
    private Long taskId;
    private String commentContent;
}