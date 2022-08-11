package com.study.member.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class MemberResponseDto {


    private String memberId;
    private String name;
    private String email;//valid
    private String phone;//valid
    private String address;
    private String password;//valid
}
