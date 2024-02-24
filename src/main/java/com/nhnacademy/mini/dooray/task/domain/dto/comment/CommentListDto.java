package com.nhnacademy.mini.dooray.task.domain.dto.comment;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class CommentListDto {
    String userId;
    Long commentId;
    String commentContent;
}
