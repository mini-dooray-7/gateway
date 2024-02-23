package com.nhnacademy.mini.dooray.user.controller;

import com.nhnacademy.mini.dooray.domain.User;
import com.nhnacademy.mini.dooray.domain.dto.NoPasswordDto;
import com.nhnacademy.mini.dooray.user.dto.UserInfoDto;
import com.nhnacademy.mini.dooray.user.dto.UserStateDto;
import com.nhnacademy.mini.dooray.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@PathVariable String id) {
        return userService.getUser(id);
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<NoPasswordDto> getUsers(@RequestParam String state) {
        return userService.getUsers(state);
    }

    @PutMapping("/users/info/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String updateUserInfo(@PathVariable String id, UserInfoDto userInfoDto) {
        if (Objects.isNull(userService.getUser(id))) {
            throw new RuntimeException("user not found");
        }
        return userService.updateUserInfo(id, userInfoDto);
    }

    @PutMapping("/users/state/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String updateUserState(@PathVariable String id, UserStateDto userStateDto) {
        if (Objects.isNull(userService.getUser(id))) {
            throw new RuntimeException("user not found");
        }
        return userService.UpdateUserState(id, userStateDto);
    }
}