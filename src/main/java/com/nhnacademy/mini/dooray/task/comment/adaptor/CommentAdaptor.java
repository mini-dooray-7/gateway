package com.nhnacademy.mini.dooray.task.comment.adaptor;

import com.nhnacademy.mini.dooray.task.domain.dto.comment.CommentCreateDto;
import com.nhnacademy.mini.dooray.task.domain.dto.comment.CommentListDto;
import com.nhnacademy.mini.dooray.task.domain.dto.comment.CommentUpdateDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentAdaptor {
    List<CommentListDto> getComments(Long taskId);
    ResponseEntity<String> createComment(Long id, CommentCreateDto commentCreateDto);
    ResponseEntity<String> updateComment(Long id, CommentUpdateDto commentUpdateDto);
    ResponseEntity<String> deleteComment(Long id);

}
