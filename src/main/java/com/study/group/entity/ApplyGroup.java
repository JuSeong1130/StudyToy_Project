package com.study.group.entity;

import com.study.audit.Auditable;
import com.study.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class ApplyGroup extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long applyGroupId;

    @Getter
    @ManyToOne
    @JoinColumn(name="MEMBER_ID")
    private Member member;

    @Getter
    @ManyToOne
    @JoinColumn(name="GROUP_ID")
    private Group group;

    @Builder
    public ApplyGroup(Long applyGroupId, Member member, Group group) {
        this.applyGroupId = applyGroupId;
        this.member = member;
        this.group = group;
    }
}
