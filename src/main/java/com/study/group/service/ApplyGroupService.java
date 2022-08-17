package com.study.group.service;

import com.study.exception.BusinessLogicException;
import com.study.exception.ExceptionCode;
import com.study.group.entity.ApplyGroup;
import com.study.group.entity.Group;
import com.study.group.entity.MemberGroup;
import com.study.group.repository.ApplyGroupRepository;
import com.study.member.entity.Member;
import com.study.member.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyGroupService {
    private ApplyGroupRepository applyGroupRepository;
    private GroupService groupService;
    private MemberService memberService;
    private MemberGroupService memberGroupService;

    public ApplyGroupService(ApplyGroupRepository applyGroupRepository, GroupService groupService, MemberService memberService, MemberGroupService memberGroupService) {
        this.applyGroupRepository = applyGroupRepository;
        this.groupService = groupService;
        this.memberService = memberService;
        this.memberGroupService = memberGroupService;
    }

    public List<ApplyGroup> getApplyGroups(Long groupId) {
        return groupService.findGroup(groupId).getApplyGroups();
    }

    public ApplyGroup createApplyGroup(Long groupId, String memberId) {
        Group findGroup = groupService.findGroup(groupId);
        Member findMember = memberService.findMember(memberId);
        ApplyGroup applyGroup = ApplyGroup.builder()
                .group(findGroup)
                .member(findMember)
                .build();
        return applyGroupRepository.save(applyGroup);
    }

    public MemberGroup applyMember(Long groupId, Long applicantId, String role) {
        ApplyGroup applyGroup = findVerifiedApplyGroup(applicantId);
        MemberGroup memberGroup = MemberGroup.builder()
                .group(applyGroup.getGroup())
                .member(applyGroup.getMember())
                .role(MemberGroup.GroupRole.valueOf(role))
                .build();
        memberGroup = memberGroupService.addMember(memberGroup);
        applyGroupRepository.delete(applyGroup);
        return memberGroup;
    }

    private ApplyGroup findVerifiedApplyGroup(Long applicantId) {
        return applyGroupRepository.findById(applicantId).orElseThrow(
                () -> new BusinessLogicException(ExceptionCode.APPLY_MEMBER_NOT_FOUND)
        );
    }
}