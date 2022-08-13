package com.study.group.service;

import com.study.exception.BusinessLogicException;
import com.study.exception.ExceptionCode;
import com.study.group.entity.Group;
import com.study.group.entity.MemberGroup;
import com.study.group.repository.GroupRepository;
import com.study.group.repository.MemberGroupRepository;
import com.study.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GroupService {
    private final GroupRepository groupRepository;
    private final MemberGroupService memberGroupService;

    public GroupService(GroupRepository groupRepository, MemberGroupService memberGroupService) {
        this.groupRepository = groupRepository;
        this.memberGroupService = memberGroupService;
    }

    public Group createGroup(Group group) {
        verifyExistedGroup(group.getGroupId());
        Member member = Member.builder()
                .memberId("aa")
                .address("ThisIsAddress")
                .email("aa@gmail.com")
                .password("ThisIsPassword")
                .role("ROLE_USER")
                .build();
        Group saveGroup = groupRepository.save(group);
        memberGroupService.createMemberGroup(member, group);
        return saveGroup;
    }

    public Group findGroup(Long groupId) {
        return findVerifiedGroup(groupId);
    }

    public Page<Group> findGroups(int page, int size) {
        return groupRepository.findAll(PageRequest.of(page, size, Sort.by("groupId").descending()));
    }

    public void deleteGroup(Long groupId) {
        Group findGroup = findVerifiedGroup(groupId);
        groupRepository.delete(findGroup);
    }

    private Group findVerifiedGroup(Long groupId) {
        Optional<Group> optionalGroup = groupRepository.findById(groupId);
        return optionalGroup.orElseThrow(() -> new BusinessLogicException(ExceptionCode.GROUP_NOT_FOUND));
    }

    private void verifyExistedGroup(Long groupId) {
        Optional<Group> group = groupRepository.findById(groupId);
        if(group.isPresent())
            throw new BusinessLogicException(ExceptionCode.GROUP_EXISTS);
    }
}
