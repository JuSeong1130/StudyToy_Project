package com.study.member.service;


import com.study.exception.BusinessLogicException;
import com.study.exception.ExceptionCode;
import com.study.member.entity.Member;
import com.study.member.repository.MemberRepository;
import com.study.utils.CustomBeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final CustomBeanUtils<Member> beanUtils;

    public MemberService(MemberRepository memberRepository, CustomBeanUtils<Member> beanUtils) {
        this.memberRepository = memberRepository;
        this.beanUtils = beanUtils;
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

    public void deleteMember(String memberId) {
        Member findMember = findVerifiedMember(memberId);

        memberRepository.delete(findMember);
    }

    public Member patchMember(Member member) {
        Member findMember = findVerifiedMember(member.getMemberId());

        return beanUtils.copyNonNullProperties(member, findMember);
    }

    public Member patchMemberRole(String memberId, String role) {
        Member findMember = findVerifiedMember(memberId);
        findMember.changeRole(role);
        return memberRepository.save(findMember);
    }

    @Transactional(readOnly = true)
    public Member findVerifiedMember(String memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);

        return optionalMember.orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
    }
}
