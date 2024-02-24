package com.nhnacademy.mini.dooray.task.comment.controller;

import com.nhnacademy.mini.dooray.account.user.service.UserService;
import com.nhnacademy.mini.dooray.task.comment.service.CommentService;
import com.nhnacademy.mini.dooray.task.domain.dto.comment.CommentCreateDto;
import com.nhnacademy.mini.dooray.task.domain.dto.comment.CommentListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final UserService userService;

    @GetMapping("/comments/{taskId}")
    public String getComments(@PathVariable Long taskId, Model model) {
        List<CommentListDto> commentList = commentService.getComments(taskId);
        model.addAttribute("commentList", commentList);
        return "/comment/list";
    }

    @PostMapping("/comments/task/{taskId}")
    public String createComment(@PathVariable Long taskId, @RequestBody CommentCreateDto commentCreateDto) {
        commentService.createComment(taskId, commentCreateDto);
        return "/comment/list";
    }

    @DeleteMapping("/comments/{commentId}")
    public String deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return "comment/list";
    }
}
