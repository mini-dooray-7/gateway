package com.nhnacademy.mini.dooray.task.task.service;

import com.nhnacademy.mini.dooray.home.ResponseException;
import com.nhnacademy.mini.dooray.task.task.adaptor.TaskMemberAdaptor;
import com.nhnacademy.mini.dooray.task.task.domain.dto.TaskMemberRegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskMemberService {
    private final TaskMemberAdaptor taskMemberAdaptor;

    public ResponseEntity<TaskMemberRegisterDto> registerTaskMember(Long taskId, TaskMemberRegisterDto taskMemberRegisterDto){
        ResponseEntity<TaskMemberRegisterDto> response = taskMemberAdaptor.registerTaskMember(taskId, taskMemberRegisterDto);
        if (response.getStatusCode().is4xxClientError()) {
            throw new ResponseException("fail register member", response);
        }
        return response;
    }
    public ResponseEntity<String> deleteTaskMember(Long taskId, String memberId){
        ResponseEntity<String> response = taskMemberAdaptor.deleteTaskMember(taskId, memberId);
        if (response.getStatusCode().is4xxClientError()) {
            throw new ResponseException("fail delete member", response);
        }
        return response;
    }
}
