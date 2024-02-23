package com.nhnacademy.mini.dooray.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.mini.dooray.account.auth.controller.AuthController;
import com.nhnacademy.mini.dooray.account.auth.service.AuthService;
import com.nhnacademy.mini.dooray.account.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

        mockMvc.perform(post("/auth/register")
                .content(objectMapper.writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void login() throws Exception {

        mockMvc.perform(get("/auth/login/{id}", "userId"))
                .andExpect(status().isOk());
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