package com.nhnacademy.mini.dooray.task.projectmember.service;

import com.nhnacademy.mini.dooray.task.domain.dto.ProjectMemberInfoDto;
import com.nhnacademy.mini.dooray.task.projectmember.adapter.ProjectMemberAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectMemberService {
    private final ProjectMemberAdapter projectMemberAdapter;

    public ResponseEntity<String> register(Long id, ProjectMemberInfoDto projectMemberInfoDto){
        return projectMemberAdapter.registerProjectMember(id, projectMemberInfoDto);
    }

    public ResponseEntity<String> delete(Long projectId, String memberId){
        return projectMemberAdapter.deleteProjectMember(projectId, memberId);
    }
}
