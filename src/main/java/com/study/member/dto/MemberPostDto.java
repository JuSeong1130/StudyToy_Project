package com.study.member.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class MemberPostDto {

    @NotBlank(message = "id는 공백이 아니여야합니다.")
    private String memberId;

    @NotBlank(message = "이름은 공백이 아니여야합니다")
    private String name;

    @NotBlank(message = "email은 공백이 아니여야합니다")
    private String email;//valid

    @NotBlank(message = "phone은 공백이 아니여야합니다")
    private String phone;//valid

    @NotBlank(message = "address는 공백이 아니여야합니다")
    private String address;

    @NotBlank(message = "password는 공백이 아니여야합니다")
    private String password;//valid

}
