package com.nhnacademy.mini.dooray.task.projectmember.adapter;

import com.nhnacademy.mini.dooray.task.domain.dto.ProjectMemberInfoDto;
import org.springframework.http.ResponseEntity;

public interface ProjectMemberAdapter {
    ResponseEntity<String> registerProjectMember(Long id, ProjectMemberInfoDto projectMemberInfoDto);
    ResponseEntity<String> deleteProjectMember(Long projectId, String memberId);
}