package com.study.post.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostsPatchDto {

    private String title;
    private String contents;
    private String image;
    private String group;

}
