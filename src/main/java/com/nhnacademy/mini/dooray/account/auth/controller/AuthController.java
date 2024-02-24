package com.nhnacademy.mini.dooray.account.auth.controller;

import com.nhnacademy.mini.dooray.account.auth.service.AuthService;
import com.nhnacademy.mini.dooray.account.domain.User;
import com.nhnacademy.mini.dooray.account.domain.dto.AuthDto;
import com.nhnacademy.mini.dooray.account.user.service.UserService;
import com.nhnacademy.mini.dooray.task.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@RequiredArgsConstructor
@Controller
public class AuthController {
    private final AuthService authService;
    private final UserService userService;
    private final ProjectService projectService;

    @PostMapping("/auth/register")
    public String register(@RequestBody User user) {
        ResponseEntity<String> entity = authService.register(user);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return "auth/login";
        }
        throw new RuntimeException("회원가입 실패 : "+entity.getStatusCode().getReasonPhrase());
    }

    @GetMapping("/auth/login/{id}")
    public String login(@PathVariable String id, Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        model.addAttribute("projects",projectService.getProjects());

        if (Objects.nonNull(user)) {
            return "home";
        }

        ResponseEntity<AuthDto> response = authService.login(id);
        if (response.getStatusCode().is2xxSuccessful()){
            session.setAttribute("user", userService.getUser((String) model.getAttribute("userId")));
            model.addAttribute("auth", response);
            return "home";
        }
        return "redirect:auth/login";
    }
}
