package com.nhnacademy.mini.dooray.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private Long projectId;
    private String projectName;
    private String projectState;
}