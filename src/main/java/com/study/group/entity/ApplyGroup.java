package com.study.group.entity;

import com.study.audit.Auditable;
import com.study.member.entity.Member;

import javax.persistence.*;

@Entity
public class ApplyGroup extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applyGroupId;

    @ManyToOne
    @JoinColumn(name="MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name="GROUP_ID")
    private Group group;

}
