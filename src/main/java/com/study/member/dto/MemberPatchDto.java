package com.study.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberPatchDto {
    private String memberId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String password;
    private String image;

    @Builder
    public MemberPatchDto(String memberId, String name, String email, String phone, String address, String password, String image) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.password = password;
        this.image = image;
    }
}