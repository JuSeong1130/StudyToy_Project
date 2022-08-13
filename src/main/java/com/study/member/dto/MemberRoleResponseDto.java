package com.study.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class MemberRoleResponseDto {
    String memberId;
    String role;

    @Builder
    public MemberRoleResponseDto(String memberId, String role) {
        this.memberId = memberId;
        this.role = role;
    }
}
