package com.study.comments.entity;

import com.study.audit.Auditable;
import com.study.member.entity.Member;
import com.study.post.entity.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Comments extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commnetsId;

    @ManyToOne
    @JoinColumn(name="MEMBER_ID", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name="POST_ID")
    private Posts posts;

    private String content;

    private Long likeCount = 0L;

    public void patchContent(String content){
        this.content=content;
    }

    @Builder
    public Comments(Long commnetsId, Member member, Posts posts, String content, Long likeCount) {
        this.commnetsId = commnetsId;
        this.member = member;
        this.posts = posts;
        this.content = content;
        this.likeCount = likeCount;
    }
}
