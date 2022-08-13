package com.study.post.entity;

import com.study.comments.entity.Comments;
import com.study.member.entity.Member;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;


    @Column(name = "GROUPS" ,nullable = false)
    private String group;

    @Column(nullable = false)
    private Integer viewCount = 0;

    @Column(nullable = false)
    private Boolean notification = false;

    @OneToMany(mappedBy = "comments")
    private List<Comments> comments =new ArrayList<>();
}
