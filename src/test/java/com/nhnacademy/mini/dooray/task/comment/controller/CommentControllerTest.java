package com.nhnacademy.mini.dooray.task.comment.controller;

import com.nhnacademy.mini.dooray.account.user.service.UserService;
import com.nhnacademy.mini.dooray.task.comment.service.CommentService;
import com.nhnacademy.mini.dooray.task.domain.dto.comment.CommentCreateDto;
import com.nhnacademy.mini.dooray.task.domain.dto.comment.CommentListDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CommentController.class)
class CommentControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    CommentService commentService;

    @MockBean
    UserService userService;

    @Test
    void getComments() throws Exception {
        Long taskId = 123L;

        CommentListDto comment1 = new CommentListDto();
        comment1.setCommentId(1L);
        comment1.setCommentContent("Comment 1");
        comment1.setUserId("user1");

        CommentListDto comment2 = new CommentListDto();
        comment2.setCommentId(2L);
        comment2.setCommentContent("Comment 2");
        comment2.setUserId("user2");

        List<CommentListDto> commentList = Arrays.asList(comment1, comment2);
        when(commentService.getComments(taskId)).thenReturn(commentList);

        mockMvc.perform(get("/comments/{taskId}", taskId))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("commentList"))
                .andExpect(view().name("/comment/list"));
    }

    @Test
    public void testCreateComment() throws Exception {
        Long taskId = 123L;

        CommentCreateDto commentCreateDto = new CommentCreateDto();
        commentCreateDto.setUserId("user1");
        commentCreateDto.setCommentContent("New comment");

        mockMvc.perform(post("/comments/task/{taskId}", taskId)
                        .content("{\"text\":\"New comment\"}")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(view().name("/comment/list"));

        verify(commentService).createComment(taskId, commentCreateDto);
    }

    @Test
    public void testDeleteComment() throws Exception {
        // Given
        Long commentId = 456L;

        // When & Then
        mockMvc.perform(delete("/comments/{commentId}", commentId))
                .andExpect(status().isOk())
                .andExpect(view().name("comment/list"));

        verify(commentService).deleteComment(commentId);
    }
}