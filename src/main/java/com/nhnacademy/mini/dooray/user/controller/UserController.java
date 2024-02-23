package com.nhnacademy.mini.dooray.user.controller;

import com.nhnacademy.mini.dooray.domain.User;
import com.nhnacademy.mini.dooray.domain.dto.NoPasswordDto;
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

    @GetMapping("/users?state={state}")
    @ResponseStatus(HttpStatus.OK)
    public List<NoPasswordDto> getUsers(@RequestParam String state) {
        return userService.getUsers(state);
    }

    @PutMapping("/users/info/{id}")
    public HttpStatus updateUserInfo(@PathVariable String id) {
        if (Objects.isNull(userService.getUser(id))) {
            return HttpStatus.NOT_FOUND;
        }
        userService.updateUserInfo(id);
        return HttpStatus.OK;
    }

    @PutMapping("/users/state/{id}")
    public HttpStatus updateUserState(@PathVariable String id) {
        if (Objects.isNull(userService.getUser(id))) {
            return HttpStatus.NOT_FOUND;
        }
        userService.UpdateUserState(id);
        return HttpStatus.OK;
    }
}
/*
@GetMapping("/accounts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account getAccount(@PathVariable Long id) {
        if (Objects.isNull(accountService.getAccount(id))) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found");
        }
        return accountService.getAccount(id);
    }
 */