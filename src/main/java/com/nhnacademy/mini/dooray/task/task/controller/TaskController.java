package com.nhnacademy.mini.dooray.task.task.controller;

import com.nhnacademy.mini.dooray.task.comment.service.CommentService;
import com.nhnacademy.mini.dooray.task.task.domain.dto.TaskCreationDto;
import com.nhnacademy.mini.dooray.task.task.domain.dto.TaskUpdateDto;
import com.nhnacademy.mini.dooray.task.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final CommentService commentService;

    @GetMapping("tasks/projects/{projectId}")
    public String getTasks(@PathVariable Long projectId, Model model) {
        model.addAttribute("taskList", taskService.getTasks(projectId));
        return "task/list";
    }

    @GetMapping("tasks/{taskId}")
    public String getTask(@PathVariable Long taskId, Model model) {
        model.addAttribute("task", taskService.getTask(taskId));
        model.addAttribute("commentList", commentService.getComments(taskId));
        return "task/view";
    }

    @PostMapping("tasks/projects/{projectId}")
    public String createTask(@PathVariable Long projectId, @RequestBody TaskCreationDto taskCreationDto){
        taskService.createTask(projectId, taskCreationDto);
        return "task/list";
    }

    @PutMapping("tasks/{taskId}")
    public String updateTask(@PathVariable Long taskId, @RequestBody TaskUpdateDto taskUpdateDto) {
        taskService.updateTask(taskId, taskUpdateDto);
        return "task/view";
    }

    @DeleteMapping("tasks/{taskId}")
    public String deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return "task/list";
    }
}
