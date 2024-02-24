package com.nhnacademy.mini.dooray.task.projectmember.adapter;

import com.nhnacademy.mini.dooray.config.ProjectRequestUrl;
import com.nhnacademy.mini.dooray.task.domain.dto.ProjectMemberInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ProjectMemberAdapterImpl implements ProjectMemberAdapter {
    private final RestTemplate restTemplate;
    private final ProjectRequestUrl url;

    @Override
    public ResponseEntity<String> registerProjectMember(Long id, ProjectMemberInfoDto projectMemberInfoDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<ProjectMemberInfoDto> requestEntity = new HttpEntity<>(projectMemberInfoDto, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                url.get()+"/projects/{id}/member",
                HttpMethod.POST,
                requestEntity,
                String.class,
                id
        );
        return responseEntity;
    }

    @Override
    public ResponseEntity<String> deleteProjectMember(Long projectId, String memberId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                url.get()+"/projects/{project_id}/member/{member_id}",
                HttpMethod.DELETE,
                requestEntity,
                String.class,
                Map.of("project_id", projectId, "member_id", memberId)
        );
        return responseEntity;
    }
}