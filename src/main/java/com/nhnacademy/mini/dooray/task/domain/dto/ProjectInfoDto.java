package com.nhnacademy.mini.dooray.task.domain.dto;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class ProjectInfoDto {
    String projectId;
    String projectName;
    String projectState;
    String userId;
}
