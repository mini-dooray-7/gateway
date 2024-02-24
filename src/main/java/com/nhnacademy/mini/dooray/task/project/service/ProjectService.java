package com.nhnacademy.mini.dooray.task.project.service;

import com.nhnacademy.mini.dooray.task.domain.Project;
import com.nhnacademy.mini.dooray.task.domain.dto.ProjectInfoDto;
import com.nhnacademy.mini.dooray.task.domain.dto.ProjectNameDto;
import com.nhnacademy.mini.dooray.task.project.adaptor.ProjectAdaptor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectAdaptor projectAdaptor;

    public ResponseEntity<String> register(ProjectNameDto projectNameDto){
        return projectAdaptor.registerProject(projectNameDto);
    }

    public ResponseEntity<ProjectInfoDto> getProject(Long id){
        return projectAdaptor.getProject(id);
    }

    public List<Project> getProjects(){
        return projectAdaptor.getProjects();
    }

    public ResponseEntity<String> update(Long id, ProjectInfoDto projectInfoDto){
        return projectAdaptor.updateProject(id, projectInfoDto);
    }

    public ResponseEntity<String> delete(Long id){
        return projectAdaptor.deleteProject(id);
    }
}
