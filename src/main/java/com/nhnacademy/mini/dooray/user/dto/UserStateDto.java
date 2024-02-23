package com.nhnacademy.mini.dooray.user.dto;

import com.nhnacademy.mini.dooray.domain.UserState;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class UserStateDto implements Serializable {
    private UserState userState;
}
