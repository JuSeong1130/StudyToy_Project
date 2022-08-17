package com.study.group.controller;

import com.study.group.dto.ApplyGroupPostDto;
import com.study.group.entity.ApplyGroup;
import com.study.group.entity.MemberGroup;
import com.study.group.mapper.ApplyGroupMapper;
import com.study.group.mapper.MemberGroupMapper;
import com.study.group.service.ApplyGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/groups/{group-id}/applicant")
public class ApplyGroupController {

    private ApplyGroupService applyGroupService;
    private ApplyGroupMapper applyGroupMapper;
    private MemberGroupMapper memberGroupMapper;

    public ApplyGroupController(ApplyGroupService applyGroupService, ApplyGroupMapper applyGroupMapper, MemberGroupMapper memberGroupMapper) {
        this.applyGroupService = applyGroupService;
        this.applyGroupMapper = applyGroupMapper;
        this.memberGroupMapper = memberGroupMapper;
    }

    @GetMapping
    public ResponseEntity getApplyGroup(@PathVariable("group-id") Long groupId) {
        List<ApplyGroup> applyGroups = applyGroupService.getApplyGroups(groupId);
        return new ResponseEntity<>(applyGroupMapper.applyGroupListToApplyGroupResponseDto(applyGroups), HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity postApplyGroup(@PathVariable("group-id") Long groupId) {
        ApplyGroup applyGroup = applyGroupService.createApplyGroup(groupId, "aa");
        return new ResponseEntity<>(applyGroupMapper.applyGroupToApplyGroupResponseDto(applyGroup), HttpStatus.CREATED);
    }

    @PostMapping("/{applicant-id}")
    public ResponseEntity postApplyMember(@PathVariable("group-id") Long groupId,
                                          @PathVariable("applicant-id") Long applicantId,
                                          @RequestBody ApplyGroupPostDto requestBody) {
        MemberGroup memberGroup = applyGroupService.applyMember(groupId, applicantId, requestBody.getRole());
        return new ResponseEntity<>(memberGroupMapper.memberGroupToApplyGroupResponseDto(memberGroup), HttpStatus.CREATED);
    }

}
