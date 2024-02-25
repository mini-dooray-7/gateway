package com.nhnacademy.mini.dooray.task.projecttag.controller;

import com.nhnacademy.mini.dooray.task.domain.Tag;
import com.nhnacademy.mini.dooray.task.domain.dto.ProjectTagNameDto;
import com.nhnacademy.mini.dooray.task.projecttag.service.ProjectTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectTagController {
    private final ProjectTagService projectTagService;

    @PostMapping("/{project_id}/tags")
    public String registerProjectTag(@PathVariable("project_id") Long projectId,@RequestBody ProjectTagNameDto projectTagNameDto) {
        projectTagService.registerProjectTag(projectId, projectTagNameDto);
        return "redirect:/projects/"+projectId;
    }

    @GetMapping("/{project_id}/tags")
    public List<Tag> getProjectTags(@PathVariable("project_id") Long projectId) {
        return projectTagService.getProjectTags(projectId).getBody();
    }

    @DeleteMapping("/{project_id}/tags/{tag_id}")
    public String deleteProjectTag(@PathVariable("project_id") Long projectId, @PathVariable("tag_id") Long tagId) {
        projectTagService.deleteProjectTag(projectId, tagId);
        return "redirect:/projects/"+projectId;
    }
}
