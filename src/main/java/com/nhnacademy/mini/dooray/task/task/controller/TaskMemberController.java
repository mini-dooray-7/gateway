package com.nhnacademy.mini.dooray.task.task.controller;

import com.nhnacademy.mini.dooray.task.task.domain.dto.TaskMemberRegisterDto;
import com.nhnacademy.mini.dooray.task.task.service.TaskMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TaskMemberController {
    private final TaskMemberService taskMemberService;

    @PostMapping("/task/{taskId}/member")
    public String registerTaskMember(@PathVariable Long taskId, TaskMemberRegisterDto taskMemberRegisterDto) {
        taskMemberService.registerTaskMember(taskId, taskMemberRegisterDto);
        return "task/view";
    }

    @DeleteMapping("/task/{taskId}/member/{memberId}")
    public String deleteTaskMember(@PathVariable Long taskId, @PathVariable String memberId) {
        taskMemberService.deleteTaskMember(taskId, memberId);
        return "task/view";
    }
}
