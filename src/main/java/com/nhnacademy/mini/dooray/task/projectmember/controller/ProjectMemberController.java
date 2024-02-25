package com.nhnacademy.mini.dooray.task.projectmember.controller;

import com.nhnacademy.mini.dooray.task.domain.dto.ProjectMemberInfoDto;
import com.nhnacademy.mini.dooray.task.projectmember.service.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectMemberController {
    private final ProjectMemberService projectMemberService;

    @PostMapping("/{id}/member")
    public String register(@PathVariable("id") Long id, @RequestBody ProjectMemberInfoDto projectMemberInfoDto) {
        projectMemberService.register(id, projectMemberInfoDto);
        return "";
    }

    @DeleteMapping("/{project_id}/member/{member_id}")
    public String delete(@PathVariable("project_id") Long projectId, @PathVariable("member_id") String memberId) {
        projectMemberService.delete(projectId, memberId);
        return "";
    }
}
