package com.nhnacademy.mini.dooray.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.mini.dooray.account.domain.User;
import com.nhnacademy.mini.dooray.account.domain.UserState;
import com.nhnacademy.mini.dooray.account.domain.dto.NoPasswordDto;
import com.nhnacademy.mini.dooray.account.user.controller.UserController;
import com.nhnacademy.mini.dooray.account.domain.dto.UserInfoDto;
import com.nhnacademy.mini.dooray.account.domain.dto.UserStateDto;
import com.nhnacademy.mini.dooray.account.user.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    private UserService userService;

    @Test
    void getUser() throws Exception {
        User user = new User("user1", "dmswl", "sdfk", "d@email.com");
        when(userService.getUser(anyString())).thenReturn(user);

        mockMvc.perform(get("/users/{id}", "user1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.userId", equalTo("user1")));
    }
    @Test
    void getUsers() throws Exception {
        List<NoPasswordDto> users = new ArrayList<>();
        users.add(new NoPasswordDto("user1", "1243", "e@mail.com", UserState.REGISTERED));
        users.add(new NoPasswordDto("user2", "3212", "werf@mail.com", UserState.REGISTERED));
        when(userService.getUsers(any())).thenReturn(users);

        mockMvc.perform(get("/users?state={state}", UserState.REGISTERED))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id", equalTo("user1")))
                .andExpect(jsonPath("$[1].id", equalTo("user2")));
    }
    @Test
    void updateUserInfo() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User("user1", "John", "Doe", "john.doe@example.com");
        UserInfoDto userInfoDto = new UserInfoDto("John", "Doe", "john.doe@example.com");
        when(userService.getUser("user1")).thenReturn(user);
        when(userService.updateUserInfo("user1", userInfoDto)).thenReturn("200 OK");
        when(userService.getUser("user2")).thenReturn(null);


        mockMvc.perform(put("/users/info/{id}", "user1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userInfoDto)))
                .andExpect(status().isOk());

        try {
            mockMvc.perform(put("/users/info/{id}", "user2")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(userInfoDto)));
        } catch (Exception e){
            Assertions.assertThatExceptionOfType(RuntimeException.class);
        }
    }

    @Test
    void updateUserState() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        UserStateDto userStateDto = new UserStateDto(UserState.REGISTERED);

        User user = new User("user1", "John", "Doe", "john.doe@example.com");
        when(userService.getUser("user1")).thenReturn(user);
        when(userService.getUser("user2")).thenReturn(null);

        when(userService.UpdateUserState("user1", userStateDto)).thenReturn("200 OK");

        mockMvc.perform(put("/users/state/{id}", "user1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userStateDto)))
                .andExpect(status().isOk());

        try {
            mockMvc.perform(put("/users/state/{id}", "user2")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(userStateDto)));
        } catch (Exception e){
            Assertions.assertThatExceptionOfType(RuntimeException.class);
        }
    }
}
