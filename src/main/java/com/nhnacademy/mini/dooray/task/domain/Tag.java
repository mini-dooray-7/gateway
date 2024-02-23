package com.nhnacademy.mini.dooray.task.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag {
    private Long tagId;
    private Long projectId;
    private String tagName;
}