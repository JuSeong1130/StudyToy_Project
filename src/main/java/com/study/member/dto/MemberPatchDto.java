package com.study.member.dto;

import lombok.Getter;

@Getter
public class MemberPatchDto {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String password;
    private String image;
}