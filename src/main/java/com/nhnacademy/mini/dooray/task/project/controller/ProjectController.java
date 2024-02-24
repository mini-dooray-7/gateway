package com.nhnacademy.mini.dooray.task.project.controller;

import com.nhnacademy.mini.dooray.task.domain.dto.ProjectInfoDto;
import com.nhnacademy.mini.dooray.task.domain.dto.ProjectNameDto;
import com.nhnacademy.mini.dooray.task.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping
    public String register(@RequestBody ProjectNameDto projectNameDto){
        ResponseEntity<String> entity = projectService.register(projectNameDto);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return "home";
        }
        throw new RuntimeException("프로젝트 등록 실패 : "+entity.getStatusCode().getReasonPhrase());
    }

    @GetMapping
    public String getProjects(){
        projectService.getProjects();
        return "";
    }

    @GetMapping("/{id}")
    public String getProject(@PathVariable("id") Long id){
        projectService.getProject(id);
        return "project/project_info";
    }

    @PutMapping("/{id}")
    public String updateProject(@PathVariable("id") Long id, ProjectInfoDto projectInfoDto){
        projectService.update(id, projectInfoDto);
        return "project/project_info";
    }

    @DeleteMapping("/{id}")
    public String deleteProject(@PathVariable("id") Long id){
        projectService.delete(id);
        return "project/project_info";
    }
}
