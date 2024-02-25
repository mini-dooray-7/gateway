package com.nhnacademy.mini.dooray.task.projecttag.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.mini.dooray.task.domain.Tag;
import com.nhnacademy.mini.dooray.task.domain.dto.ProjectTagNameDto;
import com.nhnacademy.mini.dooray.task.projectmilestone.service.ProjectMilestoneService;
import com.nhnacademy.mini.dooray.task.projecttag.service.ProjectTagService;
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
class ProjectTagControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProjectTagService projectTagService;

    @Test
    public void testRegisterProjectTag() throws Exception {
        Long projectId = 123L;
        ProjectTagNameDto projectTagNameDto = new ProjectTagNameDto();// todo
        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(post("/projects/{project_id}/tags", projectId)
                        .content(mapper.writeValueAsString(projectTagNameDto))
                        .contentType("application/json"))
                .andExpect(status().isOk());

        verify(projectTagService).registerProjectTag(projectId, projectTagNameDto);
    }

    @Test
    public void testGetProjectTags() throws Exception {
        Long projectId = 123L;
        List<Tag> tags = Arrays.asList(new Tag());//todo
        when(projectTagService.getProjectTags(projectId)).thenReturn(new ResponseEntity<>(tags, HttpStatus.OK));

        mockMvc.perform(get("/projects/{project_id}/tags", projectId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());

        verify(projectTagService).getProjectTags(projectId);
    }

    @Test
    public void testDeleteProjectTag() throws Exception {
        Long projectId = 123L;
        Long tagId = 456L;

        mockMvc.perform(delete("/projects/{project_id}/tags/{tag_id}", projectId, tagId))
                .andExpect(status().isOk());

        verify(projectTagService).deleteProjectTag(projectId, tagId);
    }
}