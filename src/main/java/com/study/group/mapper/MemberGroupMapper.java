package com.study.group.mapper;

import com.study.group.dto.ApplyGroupResponseDto;
import com.study.group.entity.MemberGroup;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MemberGroupMapper {
    default ApplyGroupResponseDto memberGroupToApplyGroupResponseDto(MemberGroup memberGroup) {
        if(memberGroup == null) {
            return null;
        } else {
            return ApplyGroupResponseDto.builder()
                    .memberId(memberGroup.getMember().getMemberId())
                    .teamName(memberGroup.getGroup().getTeamName())
                    .build();
        }
    }
}
