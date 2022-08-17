package com.study.group.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class ApplyGroupGetResponseDto {
    private List<ApplyMember> applyMembers = new ArrayList<>();

    @Getter
    @NoArgsConstructor
    public static class ApplyMember {
        private Long applyGroupId;
        private String memberId;

        @Builder
        public ApplyMember(Long applyGroupId, String memberId) {
            this.applyGroupId = applyGroupId;
            this.memberId = memberId;
        }
    }
}
