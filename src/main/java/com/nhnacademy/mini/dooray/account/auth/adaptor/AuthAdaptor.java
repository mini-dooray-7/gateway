package com.nhnacademy.mini.dooray.account.auth.adaptor;

import com.nhnacademy.mini.dooray.account.domain.User;
import com.nhnacademy.mini.dooray.account.domain.dto.AuthDto;

public interface AuthAdaptor {
    String register(User user);
    AuthDto login(String id);
}
