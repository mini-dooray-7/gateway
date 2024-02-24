package com.nhnacademy.mini.dooray.task.projectmilestone.adaptor;

import com.nhnacademy.mini.dooray.task.domain.Milestone;
import com.nhnacademy.mini.dooray.task.domain.dto.ProjectMilestoneNameDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectMilestoneAdaptor {
    ResponseEntity<String> registerProjectMilestone(Long projectId, ProjectMilestoneNameDto projectMilestoneNameDto);
    ResponseEntity<List<Milestone>> getProjectMilestones(Long projectId);
    ResponseEntity<String> deleteProjectMilestone(Long projectId, Long milestoneId);
}
