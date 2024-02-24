package com.nhnacademy.mini.dooray.task.projectmilestone.service;

import com.nhnacademy.mini.dooray.task.domain.Milestone;
import com.nhnacademy.mini.dooray.task.domain.dto.ProjectMilestoneNameDto;
import com.nhnacademy.mini.dooray.task.projectmilestone.adaptor.ProjectMilestoneAdaptor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectMilestoneService {
    private final ProjectMilestoneAdaptor projectMilestoneAdaptor;

    public ResponseEntity<String> registerProjectMilestone(Long projectId, ProjectMilestoneNameDto projectMilestoneNameDto) {
        return projectMilestoneAdaptor.registerProjectMilestone(projectId, projectMilestoneNameDto);
    }

    public ResponseEntity<List<Milestone>> getProjectMilestones(Long projectId) {
        return projectMilestoneAdaptor.getProjectMilestones(projectId);
    }

    public ResponseEntity<String> deleteProjectMilestone(Long projectId, Long milestoneId) {
        return projectMilestoneAdaptor.deleteProjectMilestone(projectId, milestoneId);
    }
}
