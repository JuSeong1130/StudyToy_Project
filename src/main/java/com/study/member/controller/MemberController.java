package com.study.member.controller;


import com.study.member.dto.MemberPatchDto;
import com.study.member.dto.MemberPostDto;
import com.study.member.dto.MemberResponseDto;
import com.study.member.dto.MemberRolePatchDto;
import com.study.member.entity.Member;
import com.study.member.mapper.MemberMapper;
import com.study.member.service.MemberService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;


@RestController
@RequestMapping("/v1/members")
@Validated
public class MemberController {

    private MemberService memberService;
    private MemberMapper memberMapper;

    public MemberController(MemberService memberService, MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto requestBody){
        System.out.println("requestBody = " + requestBody);
        Member member = memberMapper.memberPostToMember(requestBody);
        member.setRole("ROLE_USER");

        MemberResponseDto responseDto = memberMapper.memberToMemberResponseDto(memberService.createMember(member));
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") String memberId){
        Member member = memberService.findMember(memberId);
        return new ResponseEntity<>(memberMapper.memberToMemberResponseDto(member),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity getMembers(@Positive @RequestParam int page, @Positive @RequestParam int size) {
        Page<Member> pageMembers = memberService.findMembers(page - 1, size);
        return new ResponseEntity<>(pageMembers, HttpStatus.OK);
    }
    
    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") String memberId,
                                      @Valid @RequestBody MemberPatchDto requestBody) {

        //requestBody = MemberPatchDto.builder().memberId(memberId).build();
        requestBody.setMemberId(memberId);
        Member member = memberService.patchMember(memberMapper.memberPatchDtoToMember(requestBody));
        return new ResponseEntity<>(memberMapper.memberToMemberResponseDto(member), HttpStatus.OK);
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
