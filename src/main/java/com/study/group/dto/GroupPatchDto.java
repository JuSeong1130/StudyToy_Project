package com.study.group.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class GroupPatchDto {
    @Setter
    Long groupId;
    String teamName;
}
