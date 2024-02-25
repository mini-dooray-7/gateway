package com.nhnacademy.mini.dooray.task.projectmilestone.controller;

import com.nhnacademy.mini.dooray.task.domain.Milestone;
import com.nhnacademy.mini.dooray.task.domain.dto.ProjectMilestoneNameDto;
import com.nhnacademy.mini.dooray.task.projectmember.service.ProjectMemberService;
import com.nhnacademy.mini.dooray.task.projectmilestone.service.ProjectMilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectMilestoneController {
    private final ProjectMilestoneService projectMilestoneService;

    @PostMapping("/{project_id}/milestone")
    public String registerProjectMilestone(@PathVariable("project_id") Long projectId, @RequestBody ProjectMilestoneNameDto projectMilestoneNameDto) {
        projectMilestoneService.registerProjectMilestone(projectId, projectMilestoneNameDto);
        return "";
    }

    @GetMapping("/{project_id}/milestone")
    public List<Milestone> getProjectMilestones(@PathVariable("project_id") Long projectId) {
        return projectMilestoneService.getProjectMilestones(projectId).getBody();
    }

    @DeleteMapping("/{project_id}/milestone/{milestone_id}")
    public String deleteProjectMilestone(@PathVariable("project_id") Long projectId,@PathVariable("milestone_id") Long milestoneId) {
        projectMilestoneService.deleteProjectMilestone(projectId, milestoneId);
        return "";
    }
}
