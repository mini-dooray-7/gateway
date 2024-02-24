package com.nhnacademy.mini.dooray.task.domain.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentListDto {
    String userId;
    Long commentId;
    String commentContent;
}
