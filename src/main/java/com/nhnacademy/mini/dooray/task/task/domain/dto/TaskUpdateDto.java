package com.nhnacademy.mini.dooray.task.task.domain.dto;

import com.nhnacademy.mini.dooray.task.domain.ProjectState;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class TaskUpdateDto {
    private String taskTitle;
    private String taskContent;
    private ProjectState taskState;
}
