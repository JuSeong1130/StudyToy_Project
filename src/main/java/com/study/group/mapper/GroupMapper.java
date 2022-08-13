package com.study.group.mapper;

import com.study.group.dto.GroupPostDto;
import com.study.group.dto.GroupResponseDto;
import com.study.group.entity.Group;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GroupMapper {
    Group groupPostDtoToGroup(GroupPostDto requestBody);
    GroupResponseDto groupToGroupResponseDto(Group group);
}
