package com.nhnacademy.mini.dooray.task.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskUser {
    private String userId;
    private Long taskId;
    private String taskUserRole;
}
