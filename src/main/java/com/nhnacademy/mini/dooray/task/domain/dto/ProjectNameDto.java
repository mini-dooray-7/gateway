package com.nhnacademy.mini.dooray.task.domain.dto;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class ProjectNameDto {
    private String projectName;
    private String[] projectAdminIds;
}
