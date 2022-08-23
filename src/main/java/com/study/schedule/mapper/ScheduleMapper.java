package com.study.schedule.mapper;

import com.study.schedule.dto.SchedulePatchDto;
import com.study.schedule.dto.SchedulePostDto;
import com.study.schedule.dto.ScheduleRequestDto;
import com.study.schedule.entity.Schedule;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {
    Schedule schedulePostDtoToSchedule(SchedulePostDto requestBody);
    Schedule schedulePatchDtoToSchedule(SchedulePatchDto requestBody);
    ScheduleRequestDto scheduleToScheduleRequestDto(Schedule schedule);
}
