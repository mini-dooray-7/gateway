package com.nhnacademy.mini.dooray.adaptor;

import com.nhnacademy.mini.dooray.domain.dto.AuthDto;

public interface AuthAdaptor {
    String register();
    AuthDto login(String id);
}
