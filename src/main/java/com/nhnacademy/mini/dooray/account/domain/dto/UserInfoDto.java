package com.nhnacademy.mini.dooray.account.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class UserInfoDto implements Serializable {
    private String userName;
    private String userEmail;
    private String userPassword;
}
