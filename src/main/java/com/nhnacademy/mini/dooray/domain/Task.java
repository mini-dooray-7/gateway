package com.nhnacademy.mini.dooray.domain;

import java.time.LocalDateTime;

public class Task {
    private Long taskId;
    private Long milestoneId;
    private Long projectId;
    private String taskTitle;
    private String taskContent;
    private LocalDateTime taskCreatedAt;
    private String taskState;
}