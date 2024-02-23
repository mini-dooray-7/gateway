package com.nhnacademy.mini.dooray.auth.adaptor;

import com.nhnacademy.mini.dooray.domain.User;
import com.nhnacademy.mini.dooray.domain.dto.AuthDto;

public interface AuthAdaptor {
    String register(User user);
    AuthDto login(String id);
}
