package com.study.post.dto;


import com.study.comments.entity.Comments;
import com.study.member.entity.Member;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class PostsResponseDto {
    private  String title;
    private String contents;
    private String image;
    private String group;

    private Member member;

    private List<Comments> comments;

    @Builder
    public PostsResponseDto(String title, String contents, String image, String group, Member member, List<Comments> comments) {
        this.title = title;
        this.contents = contents;
        this.image = image;
        this.group = group;
        this.member = member;
        this.comments = comments;
    }
}
