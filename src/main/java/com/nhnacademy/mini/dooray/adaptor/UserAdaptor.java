package com.nhnacademy.mini.dooray.adaptor;

import com.nhnacademy.mini.dooray.domain.User;
import com.nhnacademy.mini.dooray.domain.dto.NoPasswordDto;

import java.util.List;

public interface UserAdaptor {
    List<NoPasswordDto> getUsers(String state);
    User getUser(String id);
    String updateUserInfo(String id);
    String UpdateUserState(String id);
}
