package com.nhnacademy.mini.dooray.task.project.adaptor;

import com.nhnacademy.mini.dooray.config.ProjectRequestUrl;
import com.nhnacademy.mini.dooray.task.domain.Project;
import com.nhnacademy.mini.dooray.task.domain.dto.ProjectInfoDto;
import com.nhnacademy.mini.dooray.task.domain.dto.ProjectNameDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProjectAdaptorImpl implements ProjectAdaptor{
    private final RestTemplate restTemplate;
    private final ProjectRequestUrl url;

    @Override
    public ResponseEntity<String> registerProject(ProjectNameDto projectNameDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<ProjectNameDto> requestEntity = new HttpEntity<>(projectNameDto, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                url.get()+"/projects",
                HttpMethod.POST,
                requestEntity,
                String.class
        );
        return responseEntity;
    }

    @Override
    public ResponseEntity<ProjectInfoDto> getProject(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<ProjectInfoDto> responseEntity = restTemplate.exchange(
                url.get()+"/projects/{id}",
                HttpMethod.GET,
                requestEntity,
                ProjectInfoDto.class,
                id
        );
        return responseEntity;
    }

    @Override
    public ResponseEntity<List<Project>> getProjects() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<List<Project>> responseEntity = restTemplate.exchange(
                url.get() + "/projects",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<>() {
                }
        );
        return responseEntity;
    }

    @Override
    public ResponseEntity<String> updateProject(Long id, ProjectInfoDto projectInfoDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<ProjectInfoDto> requestEntity = new HttpEntity<>(projectInfoDto, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                url.get()+"/projects/{id}",
                HttpMethod.PUT,
                requestEntity,
                String.class,
                id
        );
        return responseEntity;
    }

    @Override
    public ResponseEntity<String> deleteProject(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                url.get()+"/projects/{id}",
                HttpMethod.DELETE,
                requestEntity,
                String.class,
                id
        );
        return responseEntity;
    }
}
