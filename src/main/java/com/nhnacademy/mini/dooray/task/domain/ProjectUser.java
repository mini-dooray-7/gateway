package com.nhnacademy.mini.dooray.task.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectUser {
    private String userId;
    private Long projectId;
    private String projectUserRole;
}