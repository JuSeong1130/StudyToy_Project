package com.study.group.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ApplyGroupResponseDto {
    String memberId;
    String teamName;

    @Builder
    public ApplyGroupResponseDto(String memberId, String teamName) {
        this.memberId = memberId;
        this.teamName = teamName;
    }
}
