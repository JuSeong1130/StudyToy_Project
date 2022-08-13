package com.study.comments.dto;

import com.study.audit.Auditable;
import com.study.post.entity.Posts;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentsPostsDto extends Auditable {
    private String contents;
    private Posts posts;
    //private Long postsId; // Posts객체로 받을지 아니면 Long 타입으로 받을지
}
