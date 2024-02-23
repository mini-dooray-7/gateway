package com.nhnacademy.mini.dooray.account.domain.dto;

import com.nhnacademy.mini.dooray.account.domain.UserState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NoPasswordDto {
    private String id;
    private String name;
    private String email;
    private UserState state;
}
