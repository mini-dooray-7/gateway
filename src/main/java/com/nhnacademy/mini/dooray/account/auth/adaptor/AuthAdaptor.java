package com.nhnacademy.mini.dooray.account.auth.adaptor;

import com.nhnacademy.mini.dooray.account.domain.User;
import com.nhnacademy.mini.dooray.account.domain.dto.AuthDto;
import org.springframework.http.ResponseEntity;

public interface AuthAdaptor {
    ResponseEntity<String> register(User user);
    ResponseEntity<AuthDto> login(String id);
}
