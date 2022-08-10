package com.study.member.entity;

import com.study.audit.Auditable;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Member extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    private String image;

    @Builder
    public Member(Long memberId, String phone, String email, String address, String password, String role,String image) {
        this.memberId = memberId;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.password = password;
        this.role = role;
        this.image = image;
    }
}