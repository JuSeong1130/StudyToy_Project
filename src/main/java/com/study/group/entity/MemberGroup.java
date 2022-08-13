package com.study.group.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.study.audit.Auditable;
import com.study.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class MemberGroup extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberGroupId;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    @Column(nullable = false)
    private GroupRole role;

    public enum GroupRole {
        MANAGER(1, "Manager"),
        SUB_MANAGER(2, "Sub Manager"),
        MEMBER(3, "Member");

        @Getter
        private final int groupRoleNumber;
        @Getter
        private final String groupRolePosition;

        GroupRole(int groupRoleNumber, String groupRolePosition) {
            this.groupRoleNumber = groupRoleNumber;
            this.groupRolePosition = groupRolePosition;
        }
    }

    @Builder
    public MemberGroup(Long memberGroupId, Member member, Group group, GroupRole role) {
        this.memberGroupId = memberGroupId;
        this.member = member;
        this.group = group;
        this.role = role;
    }
}
