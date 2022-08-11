package com.study.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponseDto {
    private String memberId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String image;
    private String role;

    @Builder
    public MemberResponseDto(String memberId, String name, String email, String phone, String address, String image, String role) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.image = image;
        this.role = role;
    }
}
