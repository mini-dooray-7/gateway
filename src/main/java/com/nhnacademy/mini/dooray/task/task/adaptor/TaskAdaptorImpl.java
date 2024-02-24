package com.nhnacademy.mini.dooray.task.task.adaptor;

import com.nhnacademy.mini.dooray.config.ProjectRequestUrl;
import com.nhnacademy.mini.dooray.task.domain.Task;
import com.nhnacademy.mini.dooray.task.task.domain.dto.TaskCreationDto;
import com.nhnacademy.mini.dooray.task.task.domain.dto.TaskListDto;
import com.nhnacademy.mini.dooray.task.task.domain.dto.TaskUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TaskAdaptorImpl implements TaskAdaptor{
    private final RestTemplate restTemplate;
    private final ProjectRequestUrl url;

    @Override
    public ResponseEntity<List<TaskListDto>> getTasks(Long projectId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        return restTemplate.exchange(
                url.get()+"/task/projects/{projectId}",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<TaskListDto>>() {
                },
                projectId
        );
    }

    @Override
    public ResponseEntity<Task> getTask(Long taskId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        return restTemplate.exchange(
                url.get()+"/tasks/{taskId}",
                HttpMethod.GET,
                requestEntity,
                Task.class,
                taskId
        );
    }

    @Override
    public ResponseEntity<String> createTask(Long projectId, TaskCreationDto taskCreationDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<TaskCreationDto> requestEntity = new HttpEntity<>(taskCreationDto, headers);
        return restTemplate.exchange(
                url.get()+"/tasks/projects/{projectId}",
                HttpMethod.POST,
                requestEntity,
                String.class
        );
    }

    @Override
    public ResponseEntity<String> updateTask(Long taskId, TaskUpdateDto taskUpdateDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<TaskUpdateDto> requestEntity = new HttpEntity<>(taskUpdateDto, headers);
        return restTemplate.exchange(
                url.get()+"/tasks/{taskId}",
                HttpMethod.PUT,
                requestEntity,
                String.class,
                taskId
        );
    }

    @Override
    public ResponseEntity<String> deleteTask(Long taskId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        return restTemplate.exchange(
                url.get()+"/tasks/{taskId}",
                HttpMethod.DELETE,
                requestEntity,
                String.class,
                taskId
        );
    }
}
