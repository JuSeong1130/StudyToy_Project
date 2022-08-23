package com.study.schedule.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class SchedulePostDto {
    String title;
    String contents;
    LocalDateTime startDate;
    LocalDateTime finishDate;

    @Builder
    public SchedulePostDto(String title, String contents, LocalDateTime startDate, LocalDateTime finishDate) {
        this.title = title;
        this.contents = contents;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }
}
