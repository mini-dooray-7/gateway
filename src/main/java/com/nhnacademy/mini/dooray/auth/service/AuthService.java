package com.nhnacademy.mini.dooray.auth.service;

import com.nhnacademy.mini.dooray.auth.adaptor.AuthAdaptor;
import com.nhnacademy.mini.dooray.domain.User;
import com.nhnacademy.mini.dooray.domain.dto.AuthDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthAdaptor authAdaptor;

    public String register(User user) {
        return authAdaptor.register(user);
    }
    public AuthDto login(String id){
        return authAdaptor.login(id);
    }
}
