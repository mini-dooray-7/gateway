package com.nhnacademy.mini.dooray.task.domain.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentCreateDto {
    String userId;
    String commentContent;
}
