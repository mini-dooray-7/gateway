package com.nhnacademy.mini.dooray.task.projectmilestone.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.mini.dooray.task.domain.Milestone;
import com.nhnacademy.mini.dooray.task.domain.dto.ProjectMilestoneNameDto;
import com.nhnacademy.mini.dooray.task.projectmilestone.service.ProjectMilestoneService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class ProjectMilestoneControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProjectMilestoneService projectMilestoneService;

    @Test
    public void testRegisterProjectMilestone() throws Exception {
        Long projectId = 123L;
        ProjectMilestoneNameDto projectMilestoneNameDto = new ProjectMilestoneNameDto();// Todo
        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(post("/projects/{project_id}/milestone", projectId)
                        .content(mapper.writeValueAsString(projectMilestoneNameDto))
                        .contentType("application/json"))
                .andExpect(status().isOk());

        verify(projectMilestoneService).registerProjectMilestone(projectId, projectMilestoneNameDto);
    }

    @Test
    public void testGetProjectMilestones() throws Exception {
        Long projectId = 123L;
        List<Milestone> milestones = Arrays.asList(new Milestone());//todo

        when(projectMilestoneService.getProjectMilestones(projectId)).thenReturn(new ResponseEntity<>(milestones, HttpStatus.OK));

        mockMvc.perform(get("/projects/{project_id}/milestone", projectId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());

        verify(projectMilestoneService).getProjectMilestones(projectId);
    }

    @Test
    public void testDeleteProjectMilestone() throws Exception {
        Long projectId = 123L;
        Long milestoneId = 456L;

        mockMvc.perform(delete("/projects/{project_id}/milestone/{milestone_id}", projectId, milestoneId))
                .andExpect(status().isOk());

        verify(projectMilestoneService).deleteProjectMilestone(projectId, milestoneId);
    }
}