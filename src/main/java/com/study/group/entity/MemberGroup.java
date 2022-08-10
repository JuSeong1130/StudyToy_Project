package com.study.group.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
public class MemberGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long memberGroupId;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "groupId")
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
}
