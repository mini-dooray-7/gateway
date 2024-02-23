package com.nhnacademy.mini.dooray.account.auth.controller;

import com.nhnacademy.mini.dooray.account.auth.service.AuthService;
import com.nhnacademy.mini.dooray.account.domain.User;
import com.nhnacademy.mini.dooray.account.domain.dto.AuthDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth/register")
    public String register(@RequestBody User user) {
        ResponseEntity<String> entity = authService.register(user);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return "auth/login";
        }
        throw new RuntimeException("회원가입 실패");
    }

    @GetMapping("/auth/login/{id}")
    public String login(@PathVariable String id, Model model){
        ResponseEntity<AuthDto> response = authService.login(id);
        if (response.getStatusCode().is2xxSuccessful()){
            model.addAttribute("auth", response);
            return "userList";
        }
        return "redirect:auth/login";
    }
}
