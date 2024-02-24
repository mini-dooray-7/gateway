package com.nhnacademy.mini.dooray.task.task.controller;

import com.nhnacademy.mini.dooray.task.task.service.TaskMilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TaskMilestoneController {
    private final TaskMilestoneService taskMilestoneService;

    @PostMapping("/task/{taskId}/milestone/{milestoneId}")
    public String registerTaskMilestone(@PathVariable Long taskId, @PathVariable Long milestoneId) {
        taskMilestoneService.registerTaskMilestone(taskId, milestoneId);
        return "task/view";
    }

    @DeleteMapping("/task/{taskId}/milestone")
    public String deleteTaskMilestone(@PathVariable Long taskId) {
        taskMilestoneService.removeTaskMilestone(taskId);
        return "task/view";
    }
}
