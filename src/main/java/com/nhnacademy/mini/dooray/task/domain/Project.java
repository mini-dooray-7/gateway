package com.nhnacademy.mini.dooray.task.domain;

import com.nhnacademy.mini.dooray.task.task.domain.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    private Long projectId;
    private String projectName;
    private ProjectState projectState;
    private List<ProjectUser> projectUsers;
    private List<Task> projectTasks;
}