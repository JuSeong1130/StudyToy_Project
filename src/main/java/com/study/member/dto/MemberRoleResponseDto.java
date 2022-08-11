package com.study.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
public class MemberRoleResponseDto {
    String memberId;
    String role;

    @Builder
    public MemberRoleResponseDto(String memberId, String role) {
        this.memberId = memberId;
        this.role = role;
    }
}
