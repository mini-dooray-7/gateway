package com.nhnacademy.mini.dooray.account.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthDto {
    String userId;
    String userPassword;
}
