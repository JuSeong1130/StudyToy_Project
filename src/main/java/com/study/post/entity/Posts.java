package com.study.post.entity;

import com.study.member.entity.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Setter
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(name = "GROUPS", nullable = false)
    private String group;

    @Column(nullable = false)
    private Integer viewCount = 0;

    @Column(nullable = false)
    private Boolean notification = false;
}
