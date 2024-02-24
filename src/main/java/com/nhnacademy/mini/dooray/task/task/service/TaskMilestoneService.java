package com.nhnacademy.mini.dooray.task.task.service;

import com.nhnacademy.mini.dooray.home.ResponseException;
import com.nhnacademy.mini.dooray.task.task.adaptor.TaskMilestoneAdaptor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskMilestoneService {
    private final TaskMilestoneAdaptor taskMilestoneAdaptor;

    public ResponseEntity<String> registerTaskMilestone(Long taskId, Long milestoneId){
        ResponseEntity<String> response = taskMilestoneAdaptor.registerTaskMilestone(taskId, milestoneId);
        if (response.getStatusCode().is4xxClientError()) {
            throw new ResponseException("fail register milestone", response);
        }
        return response;
    }
    public ResponseEntity<String> removeTaskMilestone(Long taskId){
        ResponseEntity<String> response = taskMilestoneAdaptor.removeTaskMilestone(taskId);
        if (response.getStatusCode().is4xxClientError()) {
            throw new ResponseException("fail delete milestone", response);
        }
        return response;
    }
}
