package com.nhnacademy.mini.dooray.task.projectmember.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.mini.dooray.task.domain.RoleType;
import com.nhnacademy.mini.dooray.task.domain.dto.ProjectMemberInfoDto;
import com.nhnacademy.mini.dooray.task.projectmember.service.ProjectMemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class ProjectMemberControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProjectMemberService projectMemberService;

    @Test
    public void testRegister() throws Exception {
        Long id = 123L;
        ProjectMemberInfoDto projectMemberInfoDto = new ProjectMemberInfoDto("user1", RoleType.MEMBER); // TODO : 값
        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(post("/projects/{id}/member", id)
                        .content(mapper.writeValueAsString(projectMemberInfoDto))
                        .contentType("application/json"))
                .andExpect(status().isOk());

        verify(projectMemberService).register(id, projectMemberInfoDto);
    }

    @Test
    public void testDelete() throws Exception {
        Long projectId = 123L;
        String memberId = "member1";

        mockMvc.perform(delete("/projects/{project_id}/member/{member_id}", projectId, memberId))
                .andExpect(status().isOk());

        verify(projectMemberService).delete(projectId, memberId);
    }
}