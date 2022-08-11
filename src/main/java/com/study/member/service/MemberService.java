package com.study.member.service;

import com.study.member.entity.Member;
import com.study.member.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Transactional
    public Member createMember(Member member){
       memberRepository.findById(member.getMemberId()).orElseThrow(
               ()-> new RuntimeException("이미 아이디가 있습니다.")
       );
       member =memberRepository.save(member);
       return member;
    }
    @Transactional
    public Member findMember(String memberId){
        Member member=memberRepository.findById(memberId).orElseThrow(
                ()-> new RuntimeException("이미 아이디가 있습니다.")
        );
        return member;
    }
    @Transactional
    public Page<Member> findMembers(int page, int size){
        return memberRepository.findAll(PageRequest.of(page, size, Sort.by("memberId").descending()));
    }




}
