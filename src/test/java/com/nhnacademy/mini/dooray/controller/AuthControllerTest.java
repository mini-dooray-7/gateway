package com.nhnacademy.mini.dooray.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.mini.dooray.account.auth.controller.AuthController;
import com.nhnacademy.mini.dooray.account.auth.service.AuthService;
import com.nhnacademy.mini.dooray.account.domain.User;
import com.nhnacademy.mini.dooray.account.domain.dto.AuthDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthController.class)
public class AuthControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    AuthService authService;

    @Test
    void register() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User("userId", "userName", "userPW", "e@mail.com");
        when(authService.register(user)).thenReturn(ResponseEntity.status(HttpStatus.CREATED).build());

        MvcResult result = mockMvc.perform(post("/auth/register")
                .content(objectMapper.writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn();
        assertEquals("auth/login", result.getModelAndView().getViewName());
    }

    @Test
    void registerFail() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User("userId", "userName", "userPW", "e@mail.com");
        when(authService.register(user)).thenReturn(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());

        MvcResult result = mockMvc.perform(post("/auth/register")
                        .content(objectMapper.writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertEquals("error", result.getModelAndView().getViewName());
    }

    @Test
    void login() throws Exception {
        AuthDto authDto = new AuthDto("user1", "adsf");
        when(authService.login("user1")).thenReturn(ResponseEntity.status(HttpStatus.OK).body(authDto));
        when(authService.login("user2")).thenReturn(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());

        MvcResult result = mockMvc.perform(get("/auth/login/{id}", "user1"))
                .andExpect(status().isOk()).andReturn();
        assertEquals("home", result.getModelAndView().getViewName());

        mockMvc.perform(get("/auth/login/{id}", "user2"))
                .andExpect(redirectedUrl("auth/login"));
    }
}
