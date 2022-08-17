package com.study.group.service;

import com.study.exception.BusinessLogicException;
import com.study.exception.ExceptionCode;
import com.study.group.entity.Group;
import com.study.group.entity.MemberGroup;
import com.study.group.repository.MemberGroupRepository;
import com.study.member.entity.Member;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberGroupService {
    private final MemberGroupRepository memberGroupRepository;

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

    public MemberGroup addMember(MemberGroup memberGroup) {
        verifyExistsMemberGroupMember(memberGroup.getMember());
        return memberGroupRepository.save(memberGroup);
    }

    private MemberGroup findVerifiedMemberGroup(Long memberGroupId) {
        Optional<MemberGroup> findMemberGroup = memberGroupRepository.findById(memberGroupId);
        return findMemberGroup.orElseThrow(() -> new BusinessLogicException(ExceptionCode.GROUP_NOT_FOUND));
    }

    private void verifyExistsMemberGroupMember(Member member) {
        Optional<MemberGroup> findMemberGroup = memberGroupRepository.findByMember(member);
        if(findMemberGroup.isPresent())
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
    }
}
