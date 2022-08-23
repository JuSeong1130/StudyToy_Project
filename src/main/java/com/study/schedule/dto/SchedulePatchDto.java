package com.study.schedule.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class SchedulePatchDto {
    @Setter
    Long scheduleId;
    String title;
    String contents;
    LocalDateTime startDate;
    LocalDateTime finishDate;

    @Builder
    public SchedulePatchDto(Long scheduleId, String title, String contents, LocalDateTime startDate, LocalDateTime finishDate) {
        this.scheduleId = scheduleId;
        this.title = title;
        this.contents = contents;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }
}
