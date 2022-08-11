package com.study.member.mapper;


import com.study.member.dto.MemberPostDto;
import com.study.member.dto.MemberResponseDto;
import com.study.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostToMember(MemberPostDto postDto);
    MemberResponseDto memberToMemberResponseDto(Member member);
}
