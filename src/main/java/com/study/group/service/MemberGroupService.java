package com.study.group.service;

import com.study.group.entity.Group;
import com.study.group.entity.MemberGroup;
import com.study.group.repository.MemberGroupRepository;
import com.study.member.entity.Member;
import org.springframework.stereotype.Service;

@Service
public class MemberGroupService {
    private MemberGroupRepository memberGroupRepository;

    public MemberGroupService(MemberGroupRepository memberGroupRepository) {
        this.memberGroupRepository = memberGroupRepository;
    }

    public MemberGroup createMemberGroup(Member member, Group group) {
        MemberGroup memberGroup = MemberGroup.builder()
                .member(member)
                .group(group)
                .role(MemberGroup.GroupRole.MANAGER)
                .build();
        return memberGroupRepository.save(memberGroup);
    }
}
