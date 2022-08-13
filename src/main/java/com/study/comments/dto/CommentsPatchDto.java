package com.study.comments.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentsPatchDto {
    private Long commentsId;
    private String contents;
}
