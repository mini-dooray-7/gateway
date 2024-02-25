package com.nhnacademy.mini.dooray.task.task.domain.dto;

import com.nhnacademy.mini.dooray.task.domain.ProjectState;
import com.nhnacademy.mini.dooray.task.task.domain.TaskState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
public class TaskListDto {
    private Long taskId;
    private String taskTitle;
    private TaskState taskState;
}
