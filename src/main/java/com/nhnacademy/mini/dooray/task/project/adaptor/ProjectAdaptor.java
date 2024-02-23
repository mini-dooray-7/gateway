package com.nhnacademy.mini.dooray.task.project.adaptor;

import com.nhnacademy.mini.dooray.task.domain.Project;
import com.nhnacademy.mini.dooray.task.project.dto.ProjectInfoDto;
import com.nhnacademy.mini.dooray.task.project.dto.ProjectNameDto;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface ProjectAdaptor {
    HttpStatus registerProject(ProjectNameDto projectNameDto);
    ProjectInfoDto getProject(Long id);
    List<Project> getProjects();
    HttpStatus updateProject(Long id, ProjectInfoDto projectInfoDto);
    HttpStatus deleteProject(Long id);
}
