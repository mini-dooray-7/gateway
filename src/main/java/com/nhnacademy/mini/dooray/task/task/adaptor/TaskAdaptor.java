package com.nhnacademy.mini.dooray.task.task.adaptor;

import com.nhnacademy.mini.dooray.task.task.domain.Task;
import com.nhnacademy.mini.dooray.task.task.domain.dto.TaskCreationDto;
import com.nhnacademy.mini.dooray.task.task.domain.dto.TaskListDto;
import com.nhnacademy.mini.dooray.task.task.domain.dto.TaskUpdateDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskAdaptor {
    ResponseEntity<List<TaskListDto>> getTasks(Long projectId);
    ResponseEntity<Task> getTask(Long taskId);
    ResponseEntity<String> createTask(Long projectId, TaskCreationDto taskCreationDto);
    ResponseEntity<String> updateTask(Long taskId, TaskUpdateDto taskUpdateDto);
    ResponseEntity<String> deleteTask(Long taskId);
}
