package com.nhnacademy.mini.dooray.account.user.service;

import com.nhnacademy.mini.dooray.account.domain.User;
import com.nhnacademy.mini.dooray.account.domain.dto.NoPasswordDto;
import com.nhnacademy.mini.dooray.account.domain.dto.UserInfoDto;
import com.nhnacademy.mini.dooray.account.domain.dto.UserStateDto;
import com.nhnacademy.mini.dooray.account.user.adaptor.UserAdaptor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserAdaptor userAdaptor;
    public UserService(UserAdaptor userAdaptor) {
        this.userAdaptor = userAdaptor;
    }

    public List<NoPasswordDto> getUsers(String state) {
        return userAdaptor.getUsers(state);
    }

    public User getUser(String id){
        return userAdaptor.getUser(id);
    }

    public ResponseEntity<String> updateUserInfo(String id, UserInfoDto userInfoDto){
        return userAdaptor.updateUserInfo(id, userInfoDto);
    }

    public ResponseEntity<String> UpdateUserState(String id, UserStateDto userStateDto){
        return userAdaptor.UpdateUserState(id, userStateDto);
    }
}
