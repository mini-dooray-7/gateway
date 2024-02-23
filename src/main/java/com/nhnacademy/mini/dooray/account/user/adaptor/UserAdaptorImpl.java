package com.nhnacademy.mini.dooray.account.user.adaptor;

import com.nhnacademy.mini.dooray.account.domain.User;
import com.nhnacademy.mini.dooray.account.domain.dto.NoPasswordDto;
import com.nhnacademy.mini.dooray.account.domain.dto.UserInfoDto;
import com.nhnacademy.mini.dooray.account.domain.dto.UserStateDto;
import com.nhnacademy.mini.dooray.config.AccountRequestUrl;
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
    private final AccountRequestUrl url;

    @Override
    public List<NoPasswordDto> getUsers(String state) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<List<NoPasswordDto>> response = restTemplate.exchange(
                url.get()+"/users?state={state}",
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
                url.get()+"/users/{id}",
                HttpMethod.GET,
                requestEntity,
                User.class,
                id
        );
        return response.getBody();
    }

    @Override
    public ResponseEntity<String> updateUserInfo(String id, UserInfoDto userInfoDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<UserInfoDto> requestEntity = new HttpEntity<>(userInfoDto, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                url.get()+"/users/info/{id}",
                HttpMethod.PUT,
                requestEntity,
                String.class,
                id
        );
        return response;
    }

    @Override
    public ResponseEntity<String> UpdateUserState(String id, UserStateDto userStateDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<UserStateDto> requestEntity = new HttpEntity<>(userStateDto, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                url.get()+"/users/state/{id}",
                HttpMethod.PUT,
                requestEntity,
                String.class,
                id
        );
        return response;
    }

}
