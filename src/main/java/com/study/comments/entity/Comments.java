package com.study.comments.entity;

import com.study.audit.Auditable;
import com.study.member.entity.Member;
import com.study.post.entity.Posts;

import javax.persistence.*;

@Entity
public class Comments extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commnetsId;

    @ManyToOne
    @JoinColumn(name="MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name="POST_ID")
    private Posts posts;

    private String content;

    private Long likeCount;
}
