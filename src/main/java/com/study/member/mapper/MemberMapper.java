package com.study.member.mapper;


import com.study.member.dto.MemberPatchDto;
import com.study.member.dto.MemberPostDto;
import com.study.member.dto.MemberResponseDto;
import com.study.member.dto.MemberRoleResponseDto;
import com.study.member.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MemberMapper {
    Member memberPatchDtoToMember(MemberPatchDto requestBody);
    MemberResponseDto memberToMemberResponseDto(Member member);
    MemberRoleResponseDto memberToMemberRoleResponseDto(Member member);
    Member memberPostToMember(MemberPostDto postDto);

}
