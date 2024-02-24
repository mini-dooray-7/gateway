package com.nhnacademy.mini.dooray.task.task.adaptor;

import com.nhnacademy.mini.dooray.config.ProjectRequestUrl;
import com.nhnacademy.mini.dooray.task.task.domain.dto.TaskMemberRegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TaskMemberAdaptorImpl implements TaskMemberAdaptor{
    private final RestTemplate restTemplate;
    private final ProjectRequestUrl url;
    @Override
    public ResponseEntity<TaskMemberRegisterDto> registerTaskMember(Long taskId, TaskMemberRegisterDto taskMemberRegisterDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<TaskMemberRegisterDto> requestEntity = new HttpEntity<>(taskMemberRegisterDto, headers);
        return restTemplate.exchange(
                url.get() + "/task/{taskId}/member",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<TaskMemberRegisterDto>() {
                },
                taskId
        );
    }

    @Override
    public ResponseEntity<String> deleteTaskMember(Long taskId, String memberId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        return restTemplate.exchange(
                url.get()+"/task/{taskId}/member/{memberId}",
                HttpMethod.DELETE,
                requestEntity,
                String.class,
                taskId, memberId
        );
    }
}
