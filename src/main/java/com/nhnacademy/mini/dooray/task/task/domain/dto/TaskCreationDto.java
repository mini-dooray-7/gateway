package com.nhnacademy.mini.dooray.task.task.domain.dto;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class TaskCreationDto {
    private String userId;
    private String taskTitle;
    private String taskContent;
}
