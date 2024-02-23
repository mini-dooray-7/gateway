package com.nhnacademy.mini.dooray.task.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private Long taskId;
    private Long milestoneId;
    private Long projectId;
    private String taskTitle;
    private String taskContent;
    private LocalDateTime taskCreatedAt;
    private String taskState;
}