package com.study.schedule.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ScheduleRequestDto {
    private String title;
    private String contents;
    private LocalDateTime startDate;
    private LocalDateTime finishDate;

    @Builder
    public ScheduleRequestDto(String title, String contents, LocalDateTime startDate, LocalDateTime finishDate) {
        this.title = title;
        this.contents = contents;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }
}
