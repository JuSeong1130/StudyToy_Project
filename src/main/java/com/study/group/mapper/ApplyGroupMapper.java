package com.study.group.mapper;

import com.study.group.dto.ApplyGroupGetResponseDto;
import com.study.group.dto.ApplyGroupResponseDto;
import com.study.group.entity.ApplyGroup;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)

public interface ApplyGroupMapper {
    default ApplyGroupGetResponseDto applyGroupListToApplyGroupResponseDto(List<ApplyGroup> applyGroup) {
        if (applyGroup == null) {
            return null;
        } else {
            ApplyGroupGetResponseDto applyGroupGetResponseDto = new ApplyGroupGetResponseDto();
            List<ApplyGroupGetResponseDto.ApplyMember> applyMembers = applyGroupGetResponseDto.getApplyMembers();
            applyGroup.forEach(
                    group -> applyMembers.add(ApplyGroupGetResponseDto.ApplyMember.builder()
                            .applyGroupId(group.getApplyGroupId())
                            .memberId(group.getMember().getMemberId())
                            .build()));
            return applyGroupGetResponseDto;
        }
    }

    default ApplyGroupResponseDto applyGroupToApplyGroupResponseDto(ApplyGroup applyGroup) {
        if(applyGroup == null) {
            return null;
        } else {
            return ApplyGroupResponseDto.builder()
                    .memberId(applyGroup.getMember().getMemberId())
                    .teamName(applyGroup.getGroup().getTeamName())
                    .build();
        }
    }
}