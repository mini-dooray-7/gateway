package com.nhnacademy.mini.dooray.task.task.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskTag {
    private Long tagId;
    private Long taskId;
}