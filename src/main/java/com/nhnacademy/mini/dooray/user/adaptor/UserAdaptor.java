package com.nhnacademy.mini.dooray.user.adaptor;

import com.nhnacademy.mini.dooray.domain.User;
import com.nhnacademy.mini.dooray.domain.dto.NoPasswordDto;
import com.nhnacademy.mini.dooray.user.dto.UserInfoDto;
import com.nhnacademy.mini.dooray.user.dto.UserStateDto;

import java.util.List;

public interface UserAdaptor {
    List<NoPasswordDto> getUsers(String state);
    User getUser(String id);
    String updateUserInfo(String id, UserInfoDto userInfoDto);
    String UpdateUserState(String id, UserStateDto userStateDto);
}
