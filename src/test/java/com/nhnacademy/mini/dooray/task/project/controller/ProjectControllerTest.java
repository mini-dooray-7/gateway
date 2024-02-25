package com.nhnacademy.mini.dooray.task.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.mini.dooray.task.domain.dto.ProjectInfoDto;
import com.nhnacademy.mini.dooray.task.domain.dto.ProjectNameDto;
import com.nhnacademy.mini.dooray.task.project.service.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest
class ProjectControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProjectService projectService;

    @Test
    public void testRegister() throws Exception {
        ProjectNameDto projectNameDto = new ProjectNameDto(); // TODO : 값을 넣어 주세요
        ResponseEntity<String> entity = ResponseEntity.ok("Registration successful"); // TODO 여기 확인
        ObjectMapper mapper = new ObjectMapper();

        when(projectService.register(projectNameDto)).thenReturn(entity);

        mockMvc.perform(post("/projects")
                        .content(mapper.writeValueAsString(projectNameDto))
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"));
    }

    @Test
    public void testGetProjects() throws Exception {
        mockMvc.perform(get("/projects"))
                .andExpect(status().isOk());

        verify(projectService).getProjects();
    }

    @Test
    public void testGetProject() throws Exception {
        Long id = 123L;

        mockMvc.perform(get("/projects/{id}", id))
                .andExpect(status().isOk())
                .andExpect(view().name("project/project_info"));

        verify(projectService).getProject(id);
    }

    @Test
    public void testUpdateProject() throws Exception {
        Long id = 123L;
        ProjectInfoDto projectInfoDto = new ProjectInfoDto(/* Populate with required data */);// TODO : 값을 넣어주세요
        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(put("/projects/{id}", id)
                        .content(mapper.writeValueAsString(projectInfoDto))
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(view().name("project/project_info"));

        verify(projectService).update(id, projectInfoDto);
    }

    @Test
    public void testDeleteProject() throws Exception {
        Long id = 123L;

        mockMvc.perform(delete("/projects/{id}", id))
                .andExpect(status().isOk())
                .andExpect(view().name("project/project_info"));

        verify(projectService).delete(id);
    }
}