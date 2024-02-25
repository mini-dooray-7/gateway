package com.nhnacademy.mini.dooray.task.task.service;

import com.nhnacademy.mini.dooray.home.ResponseException;
import com.nhnacademy.mini.dooray.task.project.exception.ProjectNotFoundException;
import com.nhnacademy.mini.dooray.task.project.service.ProjectService;
import com.nhnacademy.mini.dooray.task.task.adaptor.TaskAdaptor;
import com.nhnacademy.mini.dooray.task.task.domain.Task;
import com.nhnacademy.mini.dooray.task.task.domain.dto.TaskCreationDto;
import com.nhnacademy.mini.dooray.task.task.domain.dto.TaskListDto;
import com.nhnacademy.mini.dooray.task.task.domain.dto.TaskUpdateDto;
import com.nhnacademy.mini.dooray.task.task.exception.TaskNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskAdaptor taskAdaptor;
    private final ProjectService projectService;

    public ResponseEntity<List<TaskListDto>> getTasks(Long projectId){
        ResponseEntity<List<TaskListDto>> response = taskAdaptor.getTasks(projectId);
        if (response.getStatusCode().is4xxClientError()) {
            throw new ResponseException("fail get task list", response);
        }
        return response;
    }
    public ResponseEntity<Task> getTask(Long taskId) {
        ResponseEntity<Task> response = taskAdaptor.getTask(taskId);
        if (response.getStatusCode().is4xxClientError()) {
            throw new ResponseException("get task list is fail", response);
        }
        return response;
    }
    public ResponseEntity<String> createTask(Long projectId, TaskCreationDto taskCreationDto) {
        if (Objects.nonNull(projectService.getProject(projectId))) {
            throw new ProjectNotFoundException(projectId);
        }

        ResponseEntity<String> response = taskAdaptor.createTask(projectId, taskCreationDto);
        if (response.getStatusCode().is4xxClientError()) {
            throw new ResponseException("create task is fail", response);
        }
        return response;
    }
    public ResponseEntity<String> updateTask(Long taskId, TaskUpdateDto taskUpdateDto){
        if (Objects.nonNull(taskAdaptor.getTask(taskId))) {
            throw new TaskNotFoundException(taskId);
        }

        ResponseEntity<String> response = taskAdaptor.updateTask(taskId, taskUpdateDto);
        if (response.getStatusCode().is4xxClientError()) {
            throw new ResponseException("get task is fail", response);
        }
        return response;
    }
    public ResponseEntity<String> deleteTask(Long taskId){
        if (Objects.nonNull(taskAdaptor.getTask(taskId))) {
            throw new TaskNotFoundException(taskId);
        }

        ResponseEntity<String> response = taskAdaptor.deleteTask(taskId);
        if (response.getStatusCode().is4xxClientError()) {
            throw new ResponseException("delete task is fail", response);
        }
        return response;
    }
}
