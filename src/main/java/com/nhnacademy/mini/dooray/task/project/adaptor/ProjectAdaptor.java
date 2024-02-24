package com.nhnacademy.mini.dooray.task.project.adaptor;

import com.nhnacademy.mini.dooray.task.domain.Project;
import com.nhnacademy.mini.dooray.task.domain.dto.ProjectInfoDto;
import com.nhnacademy.mini.dooray.task.domain.dto.ProjectNameDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectAdaptor {
    ResponseEntity<String> registerProject(ProjectNameDto projectNameDto);
    ResponseEntity<ProjectInfoDto> getProject(Long id);
    List<Project> getProjects();
    ResponseEntity<String> updateProject(Long id, ProjectInfoDto projectInfoDto);
    ResponseEntity<String> deleteProject(Long id);
}
