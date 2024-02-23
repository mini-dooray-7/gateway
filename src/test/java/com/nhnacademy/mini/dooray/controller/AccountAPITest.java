package com.nhnacademy.mini.dooray.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.mini.dooray.domain.User;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountAPITest {
    @Autowired
    private MockMvc mockMvc;

    @Order(1)
    @Test
    void register() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User("userId", "userName", "userPW", "e@mail.com");

        mockMvc.perform(post("/auth/register")
                .content(objectMapper.writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", equalTo("userId")));
    }

    @Order(2)
    @Test
    void login() throws Exception {

        mockMvc.perform(get("/auth/login/{id}", "userId"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", equalTo("userId")))
                .andExpect(jsonPath("$.password", equalTo("userPW")));
    }
    @Order(3)
    @Test
    void getUsers() throws Exception {
        mockMvc.perform(get("/users?state={state}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id", equalTo("userId")));
    }
}

/*
@Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @Order(1)
    void register() throws  Exception{
        User user = new User("id", "user1", "543", "e1@email.com");
        ResponseEntity<User> exchange = testRestTemplate.postForEntity(
                "/auth/register",
                user,
                User.class
        );
        assertThat(exchange.getBody()).isEqualTo(new User("id", "user1", "543", "e1@email.com"));
    }
 */