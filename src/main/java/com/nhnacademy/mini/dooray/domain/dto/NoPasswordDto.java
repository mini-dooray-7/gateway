package com.nhnacademy.mini.dooray.domain.dto;

import com.nhnacademy.mini.dooray.domain.UserState;
import lombok.Getter;

@Getter
public class NoPasswordDto {
    private String id;
    private String name;
    private String email;
    private UserState state;
}
