package com.nhnacademy.mini.dooray.controller;

import com.nhnacademy.mini.dooray.domain.dto.AuthDto;
import com.nhnacademy.mini.dooray.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth/register")
    @ResponseStatus(HttpStatus.OK)
    public String register() {
        return authService.register();
    }

    @GetMapping("/auth/login/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthDto login(@PathVariable String id){
        return authService.login(id);
    }
}
