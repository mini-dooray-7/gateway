package com.nhnacademy.mini.dooray.task.projecttag.adaptor;

import com.nhnacademy.mini.dooray.task.domain.Tag;
import com.nhnacademy.mini.dooray.task.domain.dto.ProjectTagNameDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectTagAdaptor {
    ResponseEntity<String> registerProjectTag(Long projectId, ProjectTagNameDto projectTagNameDto);
    ResponseEntity<List<Tag>> getProjectTags(Long projectId);
    ResponseEntity<String> deleteProjectTag(Long projectId, Long tagId);
}
