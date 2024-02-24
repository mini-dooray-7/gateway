package com.nhnacademy.mini.dooray.task.task.adaptor;

import com.nhnacademy.mini.dooray.config.ProjectRequestUrl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TaskMilestoneAdaptorImpl implements TaskMilestoneAdaptor{
    private final RestTemplate restTemplate;
    private final ProjectRequestUrl url;

    @Override
    public ResponseEntity<String> registerTaskMilestone(Long taskId, Long milestoneId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        return restTemplate.exchange(
                url.get() + "/task/{taskId}/milestone/{milestoneId}",
                HttpMethod.POST,
                requestEntity,
                String.class,
                taskId, milestoneId
        );
    }

    @Override
    public ResponseEntity<String> removeTaskMilestone(Long taskId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        return restTemplate.exchange(
                url.get()+"/task/{taskId}/milestone",
                HttpMethod.DELETE,
                requestEntity,
                String.class,
                taskId
        );
    }
}
