package com.nhnacademy.mini.dooray.task.task.adaptor;

import org.springframework.http.ResponseEntity;

public interface TaskMilestoneAdaptor {
    ResponseEntity<String> registerTaskMilestone(Long taskId, Long milestoneId);
    ResponseEntity<String> removeTaskMilestone(Long taskId);
}
