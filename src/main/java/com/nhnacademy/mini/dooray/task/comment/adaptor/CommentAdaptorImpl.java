package com.nhnacademy.mini.dooray.task.comment.adaptor;

import com.nhnacademy.mini.dooray.config.AccountRequestUrl;
import com.nhnacademy.mini.dooray.task.domain.dto.comment.CommentCreateDto;
import com.nhnacademy.mini.dooray.task.domain.dto.comment.CommentListDto;
import com.nhnacademy.mini.dooray.task.domain.dto.comment.CommentUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CommentAdaptorImpl implements CommentAdaptor {
    private final RestTemplate restTemplate;
    private final AccountRequestUrl url;

    @Override
    public List<CommentListDto> getComments(Long taskId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<List<CommentListDto>> response = restTemplate.exchange(
                url.get()+"/comments/{taskId}",
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<CommentListDto>>() {
                },
                taskId
        );
        return response.getBody();
    }

    @Override
    public ResponseEntity<String> createComment(Long id, CommentCreateDto commentCreateDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<CommentCreateDto> requestEntity = new HttpEntity<>(commentCreateDto, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                url.get()+"/comments/{taskId}",
                HttpMethod.POST,
                requestEntity,
                String.class
        );
        return responseEntity;
    }

    @Override
    public ResponseEntity<String> updateComment(Long id, CommentUpdateDto commentUpdateDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<CommentUpdateDto> requestEntity = new HttpEntity<>(commentUpdateDto, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                url.get()+"/comments/{taskId}",
                HttpMethod.PUT,
                requestEntity,
                String.class,
                id
        );
        return response;
    }

    @Override
    public ResponseEntity<String> deleteComment(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                url.get()+"/comments/{taskId}",
                HttpMethod.DELETE,
                requestEntity,
                String.class,
                id
        );
        return responseEntity;
    }
}
