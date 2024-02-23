package com.nhnacademy.mini.dooray.user.service;

import com.nhnacademy.mini.dooray.domain.User;
import com.nhnacademy.mini.dooray.domain.dto.NoPasswordDto;
import com.nhnacademy.mini.dooray.user.adaptor.UserAdaptor;
import com.nhnacademy.mini.dooray.user.dto.UserInfoDto;
import com.nhnacademy.mini.dooray.user.dto.UserStateDto;
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

    public String updateUserInfo(String id, UserInfoDto userInfoDto){
        return userAdaptor.updateUserInfo(id, userInfoDto);
    }

    public String UpdateUserState(String id, UserStateDto userStateDto){
        return userAdaptor.UpdateUserState(id, userStateDto);
    }
}
