package com.nhnacademy.mini.dooray.task.comment.service;

import com.nhnacademy.mini.dooray.task.comment.adaptor.CommentAdaptor;
import com.nhnacademy.mini.dooray.task.comment.exception.CommentIsAlreadyExistException;
import com.nhnacademy.mini.dooray.task.comment.exception.CommentNotFoundException;
import com.nhnacademy.mini.dooray.task.domain.dto.comment.CommentCreateDto;
import com.nhnacademy.mini.dooray.task.domain.dto.comment.CommentListDto;
import com.nhnacademy.mini.dooray.task.domain.dto.comment.CommentUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentAdaptor commentAdaptor;

    public List<CommentListDto> getComments(Long taskId){
        return commentAdaptor.getComments(taskId);
    }
    public ResponseEntity<String> createComment(Long id, CommentCreateDto commentCreateDto){
        if (Objects.nonNull(commentAdaptor.getComments(id))) {
            throw new CommentIsAlreadyExistException(id);
        }
        return commentAdaptor.createComment(id, commentCreateDto);
    }
    public ResponseEntity<String> updateComment(Long id, CommentUpdateDto commentUpdateDto) {
        if (Objects.isNull(commentAdaptor.getComments(id))) {
            throw new CommentNotFoundException(id);
        }
        return commentAdaptor.updateComment(id, commentUpdateDto);
    }
    public ResponseEntity<String> deleteComment(Long id) {
        if (Objects.isNull(commentAdaptor.getComments(id))) {
            throw new CommentNotFoundException(id);
        }
        return commentAdaptor.deleteComment(id);
    }
}
