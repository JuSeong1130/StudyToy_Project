package com.study.member.dto;

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
}
