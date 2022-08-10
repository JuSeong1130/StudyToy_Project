package com.study.comments.entity;

import com.study.audit.Auditable;
import com.study.member.entity.Member;

import javax.persistence.*;

public class Comments extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commnetsId;

    @ManyToOne
    @JoinColumn(name="MEMBER_ID")
    private Member member;

    @JoinColumn(name="POST_ID")
    private Post post;

    private String content;

    private Long likeCount;



}