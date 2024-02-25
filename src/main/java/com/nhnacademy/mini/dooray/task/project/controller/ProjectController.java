package com.nhnacademy.mini.dooray.task.project.controller;

import com.nhnacademy.mini.dooray.task.domain.ProjectState;
import com.nhnacademy.mini.dooray.task.domain.RoleType;
import com.nhnacademy.mini.dooray.task.domain.dto.ProjectInfoDto;
import com.nhnacademy.mini.dooray.task.domain.dto.ProjectNameDto;
import com.nhnacademy.mini.dooray.task.project.service.ProjectService;
import com.nhnacademy.mini.dooray.task.projectmilestone.service.ProjectMilestoneService;
import com.nhnacademy.mini.dooray.task.projecttag.service.ProjectTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;
    private final ProjectMilestoneService projectMilestoneService;
    private final ProjectTagService projectTagService;

    @PostMapping
    public String register(@RequestBody ProjectNameDto projectNameDto){
        ResponseEntity<String> entity = projectService.register(projectNameDto);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return "home";
        }
        throw new RuntimeException("프로젝트 등록 실패 : "+entity.getStatusCode().getReasonPhrase());
    }

    @GetMapping
    public String getProjects(Model model){
        model.addAttribute("projectList",projectService.getProjects());
        return "project/project_list";
    }

    @GetMapping("/{id}")
    public String getProject(@PathVariable("id") Long id, Model model){
        model.addAttribute("project", projectService.getProject(id).getBody());
        model.addAttribute("project_milestones", projectMilestoneService.getProjectMilestones(id).getBody());
        model.addAttribute("project_tags", projectTagService.getProjectTags(id).getBody());
        model.addAttribute("userRoles", RoleType.values());
        return "project/project_info";
    }

    @GetMapping("/edit/{id}")
    public String getProjectEditForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("projectStates", ProjectState.values());
        return "project/project_edit";
    }

    @PutMapping("/{id}")
    public String updateProject(@PathVariable("id") Long id, @RequestBody ProjectInfoDto projectInfoDto){
        projectService.update(id, projectInfoDto);
        return "redirect:/projects/"+id;
    }

    @DeleteMapping("/{id}")
    public String deleteProject(@PathVariable("id") Long id){
        projectService.delete(id);
        return "redirect:/projects/"+id;
    }
}
