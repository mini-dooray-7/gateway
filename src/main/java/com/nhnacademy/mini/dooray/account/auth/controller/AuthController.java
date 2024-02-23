package com.nhnacademy.mini.dooray.account.auth.controller;

import com.nhnacademy.mini.dooray.account.auth.service.AuthService;
import com.nhnacademy.mini.dooray.account.domain.User;
import com.nhnacademy.mini.dooray.account.domain.dto.AuthDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String register(@RequestBody User user) {
        return authService.register(user);
    }

    @GetMapping("/auth/login/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthDto login(@PathVariable String id){
        return authService.login(id);
    }
}
