package com.study.group.entity;

import com.study.audit.Auditable;
import com.study.member.entity.Member;

import javax.persistence.*;

@Entity
public class InviteGroup extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inviteGroupId;

    @ManyToOne
    @JoinColumn(name="MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name="GROUP_ID")
    private Group group;

}
