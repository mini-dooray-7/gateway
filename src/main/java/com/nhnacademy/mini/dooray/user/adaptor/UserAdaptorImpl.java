package com.nhnacademy.mini.dooray.user.adaptor;

import com.nhnacademy.mini.dooray.domain.User;
import com.nhnacademy.mini.dooray.domain.dto.NoPasswordDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserAdaptorImpl implements UserAdaptor{
    private final RestTemplate restTemplate;

    @Override
    public List<NoPasswordDto> getUsers(String state) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<List<NoPasswordDto>> response = restTemplate.exchange(
                "http://localhost:8080/users?state={state}",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<NoPasswordDto>>() {
                },
                state
        );
        return response.getBody();
    }

    @Override
    public User getUser(String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<User> response = restTemplate.exchange(
                "http://localhost:8080/users/{id}",
                HttpMethod.GET,
                requestEntity,
                User.class,
                id
        );
        return response.getBody();
    }

    @Override
    public String updateUserInfo(String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                "http://localhost:8080/users/info/{id}",
                HttpMethod.PUT,
                requestEntity,
                String.class,
                id
        );
        return response.getBody();
    }

    @Override
    public String UpdateUserState(String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                "http://localhost:8080/users/state/{id}",
                HttpMethod.PUT,
                requestEntity,
                String.class,
                id
        );
        return response.getBody();
    }

}
