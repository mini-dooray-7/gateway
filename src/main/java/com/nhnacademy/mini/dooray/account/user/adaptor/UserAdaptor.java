package com.nhnacademy.mini.dooray.account.user.adaptor;

import com.nhnacademy.mini.dooray.account.domain.dto.UserInfoDto;
import com.nhnacademy.mini.dooray.account.domain.dto.UserStateDto;
import com.nhnacademy.mini.dooray.account.domain.User;
import com.nhnacademy.mini.dooray.account.domain.dto.NoPasswordDto;

import java.util.List;

public interface UserAdaptor {
    List<NoPasswordDto> getUsers(String state);
    User getUser(String id);
    String updateUserInfo(String id, UserInfoDto userInfoDto);
    String UpdateUserState(String id, UserStateDto userStateDto);
}
