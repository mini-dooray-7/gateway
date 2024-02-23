package com.nhnacademy.mini.dooray.account.user.controller;

import com.nhnacademy.mini.dooray.account.domain.dto.UserInfoDto;
import com.nhnacademy.mini.dooray.account.domain.dto.UserStateDto;
import com.nhnacademy.mini.dooray.account.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable String id, Model model) {
        model.addAttribute(userService.getUser(id));
        return "user/info";
    }

    @GetMapping("/users")
    public String getUsers(@RequestParam String state, Model model) {
       model.addAttribute(userService.getUsers(state));
       return "user/list";
    }

    @GetMapping("/users/edit/{id}")
    public String updateUserProfile(@PathVariable String id) {
        return "user/edit";
    }

    @PutMapping("/users/info/{id}")
    public String updateUserInfo(@PathVariable String id, UserInfoDto userInfoDto) {
        if (Objects.isNull(userService.getUser(id))) {
            throw new RuntimeException("user not found");
        }
        userService.updateUserInfo(id, userInfoDto);
        return "user/info";
    }

    @PutMapping("/users/state/{id}")
    public String updateUserState(@PathVariable String id, UserStateDto userStateDto) {
        if (Objects.isNull(userService.getUser(id))) {
            throw new RuntimeException("user not found");
        }
        userService.UpdateUserState(id, userStateDto);
        return "auth/login";
    }
}