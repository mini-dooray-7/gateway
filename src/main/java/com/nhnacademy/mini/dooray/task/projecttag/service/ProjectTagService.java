package com.nhnacademy.mini.dooray.task.projecttag.service;

import com.nhnacademy.mini.dooray.task.domain.Tag;
import com.nhnacademy.mini.dooray.task.domain.dto.ProjectTagNameDto;
import com.nhnacademy.mini.dooray.task.projecttag.adaptor.ProjectTagAdaptor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectTagService {
    private final ProjectTagAdaptor projectTagAdaptor;

    public ResponseEntity<String> registerProjectTag(Long projectId, ProjectTagNameDto projectTagNameDto) {
        return projectTagAdaptor.registerProjectTag(projectId, projectTagNameDto);
    }

    public ResponseEntity<List<Tag>> getProjectTags(Long projectId) {
        return projectTagAdaptor.getProjectTags(projectId);
    }

    public ResponseEntity<String> deleteProjectTag(Long projectId, Long tagId) {
        return projectTagAdaptor.deleteProjectTag(projectId, tagId);
    }
}
