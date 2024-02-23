package com.nhnacademy.mini.dooray.user.service;

import com.nhnacademy.mini.dooray.domain.User;
import com.nhnacademy.mini.dooray.domain.dto.NoPasswordDto;
import com.nhnacademy.mini.dooray.user.adaptor.UserAdaptor;
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

    public String updateUserInfo(String id){
        return userAdaptor.updateUserInfo(id);
    }

    public String UpdateUserState(String id){
        return userAdaptor.UpdateUserState(id);
    }
}
