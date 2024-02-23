package com.nhnacademy.mini.dooray.account.auth.service;

import com.nhnacademy.mini.dooray.account.auth.adaptor.AuthAdaptor;
import com.nhnacademy.mini.dooray.account.domain.User;
import com.nhnacademy.mini.dooray.account.domain.dto.AuthDto;
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
