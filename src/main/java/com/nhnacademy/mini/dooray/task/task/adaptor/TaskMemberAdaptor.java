package com.nhnacademy.mini.dooray.task.task.adaptor;

import com.nhnacademy.mini.dooray.task.task.domain.dto.TaskMemberRegisterDto;
import org.springframework.http.ResponseEntity;

public interface TaskMemberAdaptor {
    ResponseEntity<TaskMemberRegisterDto> registerTaskMember(Long taskId, TaskMemberRegisterDto taskMemberRegisterDto);
    ResponseEntity<String> deleteTaskMember(Long taskId, String memberId);
}
