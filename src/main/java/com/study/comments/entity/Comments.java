package com.study.comments.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.study.audit.Auditable;
import com.study.member.entity.Member;
import com.study.post.entity.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Setter
public class Comments extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commnetsId;

    @ManyToOne
    @JoinColumn(name="MEMBER_ID", nullable = false)

    private Member member;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="POST_ID" ,nullable = false)
    private Posts posts;

    private String contents;

    private Long likeCount = 0L;


    public void patchContent(String contents){
        this.contents=contents;
    }

    @Builder
    public Comments(Long commnetsId, Member member, Posts posts, String contents) {
        this.commnetsId = commnetsId;
        this.member = member;
        this.posts = posts;
        this.contents = contents;

    }
}
