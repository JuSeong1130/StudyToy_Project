package com.study.group.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GroupResponseDto {
    String title;
    String teamName;

    @Builder
    public GroupResponseDto(String title, String teamName) {
        this.title = title;
        this.teamName = teamName;
    }
}
