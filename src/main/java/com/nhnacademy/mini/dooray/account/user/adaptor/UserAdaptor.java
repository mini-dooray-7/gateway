package com.nhnacademy.mini.dooray.account.user.adaptor;

import com.nhnacademy.mini.dooray.account.domain.User;
import com.nhnacademy.mini.dooray.account.domain.dto.NoPasswordDto;
import com.nhnacademy.mini.dooray.account.domain.dto.UserInfoDto;
import com.nhnacademy.mini.dooray.account.domain.dto.UserStateDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserAdaptor {
    List<NoPasswordDto> getUsers(String state);
    User getUser(String id);
    ResponseEntity<String> updateUserInfo(String id, UserInfoDto userInfoDto);
    ResponseEntity<String> UpdateUserState(String id, UserStateDto userStateDto);
}
