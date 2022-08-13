package com.study.post.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private final String title;
    private final String contents;
    private final String image;
    private final String group;

    @Builder
    public PostsResponseDto(String title, String contents, String image, String group) {
        this.title = title;
        this.contents = contents;
        this.image = image;
        this.group = group;
    }
}
