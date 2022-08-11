package com.study.member.controller;

import com.study.member.dto.MemberPatchDto;
import com.study.member.dto.MemberRolePatchDto;
import com.study.member.entity.Member;
import com.study.member.mapper.MemberMapper;
import com.study.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/members")
public class MemberController {
    private MemberService memberService;
    private MemberMapper memberMapper;

    public MemberController(MemberService memberService, MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") String memberId,
                                      @Valid @RequestBody MemberPatchDto requestBody) {
        Member member = memberService.patchMember(memberMapper.memberPatchDtoToMember(requestBody));
        return new ResponseEntity<>(memberMapper.memberToMemberResponse(member), HttpStatus.OK);
    }

    @PatchMapping("/{member-id}/role")
    public ResponseEntity patchMemberRole(@PathVariable("member-id") String memberId,
                                          @RequestBody MemberRolePatchDto requestBody) {
        Member member = memberService.patchMemberRole(memberId, requestBody.getRole());
        return new ResponseEntity<>(memberMapper.memberToMemberRoleResponseDto(member), HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") String memberId) {
        memberService.deleteMember(memberId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
