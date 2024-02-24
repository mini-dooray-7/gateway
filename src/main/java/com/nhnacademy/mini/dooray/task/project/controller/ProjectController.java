package com.nhnacademy.mini.dooray.task.project.controller;

import com.nhnacademy.mini.dooray.task.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class ProjectController {
    private final ProjectService projectService;


}
