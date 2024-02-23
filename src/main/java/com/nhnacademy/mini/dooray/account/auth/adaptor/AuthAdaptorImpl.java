package com.nhnacademy.mini.dooray.account.auth.adaptor;

import com.nhnacademy.mini.dooray.account.domain.User;
import com.nhnacademy.mini.dooray.account.domain.dto.AuthDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthAdaptorImpl implements AuthAdaptor{
    private final RestTemplate restTemplate;

    @Override
    public String register(User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<User> requestEntity = new HttpEntity<>(user, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                "http://localhost:8080/auth/register",
                HttpMethod.POST,
                requestEntity,
                String.class
        );
        return responseEntity.getBody();
    }

    @Override
    public AuthDto login(String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<AuthDto> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<AuthDto> responseEntity = restTemplate.exchange(
                "http://localhost:8080/auth/login/{id}",
                HttpMethod.GET,
                requestEntity,
                AuthDto.class,
                id
        );
        return responseEntity.getBody();
    }
}
