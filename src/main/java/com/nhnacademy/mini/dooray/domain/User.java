package com.nhnacademy.mini.dooray.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class User {
    public User(String userId, String userName, String userPassword, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userState = UserState.REGISTERED;
    }

    private String userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private UserState userState;
}
