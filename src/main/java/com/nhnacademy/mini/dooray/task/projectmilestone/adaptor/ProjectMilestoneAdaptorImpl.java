package com.nhnacademy.mini.dooray.task.projectmilestone.adaptor;

import com.nhnacademy.mini.dooray.config.ProjectRequestUrl;
import com.nhnacademy.mini.dooray.task.domain.Milestone;
import com.nhnacademy.mini.dooray.task.domain.Tag;
import com.nhnacademy.mini.dooray.task.domain.dto.ProjectMilestoneNameDto;
import com.nhnacademy.mini.dooray.task.domain.dto.ProjectTagNameDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ProjectMilestoneAdaptorImpl implements ProjectMilestoneAdaptor{
    private final RestTemplate restTemplate;
    private final ProjectRequestUrl url;

    @Override
    public ResponseEntity<String> registerProjectMilestone(Long projectId, ProjectMilestoneNameDto projectMilestoneNameDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<ProjectMilestoneNameDto> requestEntity = new HttpEntity<>(projectMilestoneNameDto, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                url.get()+"/projects/{project_id}/milestone",
                HttpMethod.POST,
                requestEntity,
                String.class,
                projectId
        );
        return responseEntity;
    }

    @Override
    public ResponseEntity<List<Milestone>> getProjectMilestones(Long projectId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<List<Milestone>> responseEntity = restTemplate.exchange(
                url.get() + "/projects/{project_id}/milestone",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {
                },
                projectId
        );
        return responseEntity;
    }

    @Override
    public ResponseEntity<String> deleteProjectMilestone(Long projectId, Long milestoneId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                url.get() + "/projects/{project_id}/milestone/{milestone_id}",
                HttpMethod.DELETE,
                requestEntity,
                String.class,
                Map.of("project_id",projectId,"milestone_id",milestoneId)
        );
        return responseEntity;
    }
}
