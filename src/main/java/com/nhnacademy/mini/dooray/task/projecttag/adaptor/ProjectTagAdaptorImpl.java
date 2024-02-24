package com.nhnacademy.mini.dooray.task.projecttag.adaptor;

import com.nhnacademy.mini.dooray.config.ProjectRequestUrl;
import com.nhnacademy.mini.dooray.task.domain.Tag;
import com.nhnacademy.mini.dooray.task.domain.dto.ProjectNameDto;
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
public class ProjectTagAdaptorImpl implements ProjectTagAdaptor{
    private final RestTemplate restTemplate;
    private final ProjectRequestUrl url;

    @Override
    public ResponseEntity<String> registerProjectTag(Long projectId, ProjectTagNameDto projectTagNameDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<ProjectTagNameDto> requestEntity = new HttpEntity<>(projectTagNameDto, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                url.get()+"/projects/{project_id}/tags",
                HttpMethod.POST,
                requestEntity,
                String.class,
                projectId
        );
        return responseEntity;
    }

    @Override
    public ResponseEntity<List<Tag>> getProjectTags(Long projectId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<List<Tag>> responseEntity = restTemplate.exchange(
                url.get() + "/projects/{project_id}/tags",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {
                },
                projectId
        );
        return responseEntity;
    }

    @Override
    public ResponseEntity<String> deleteProjectTag(Long projectId, Long tagId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                url.get() + "/projects/{project_id}/tags/{tag_id}",
                HttpMethod.DELETE,
                requestEntity,
                String.class,
                Map.of("project_id",projectId,"tag_id",tagId)
        );
        return responseEntity;
    }
}
