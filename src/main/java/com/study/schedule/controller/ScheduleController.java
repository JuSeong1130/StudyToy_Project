package com.study.schedule.controller;

import com.study.group.entity.Group;
import com.study.group.service.GroupService;
import com.study.schedule.dto.SchedulePatchDto;
import com.study.schedule.dto.SchedulePostDto;
import com.study.schedule.entity.Schedule;
import com.study.schedule.mapper.ScheduleMapper;
import com.study.schedule.service.ScheduleService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/v1/groups/{group-id}/schedule")
public class ScheduleController {
    private ScheduleService scheduleService;
    private ScheduleMapper scheduleMapper;
    private GroupService groupService;

    public ScheduleController(ScheduleService scheduleService, ScheduleMapper scheduleMapper, GroupService groupService) {
        this.scheduleService = scheduleService;
        this.scheduleMapper = scheduleMapper;
        this.groupService = groupService;
    }

    @PostMapping
    public ResponseEntity postSchedule(@PathVariable("group-id") Long groupId,
                                       @RequestBody SchedulePostDto requestBody) {
        Schedule schedule = scheduleMapper.schedulePostDtoToSchedule(requestBody);
        schedule.setGroup(groupService.findGroup(groupId));
        schedule = scheduleService.createSchedule(schedule);
        return new ResponseEntity<>(scheduleMapper.scheduleToScheduleRequestDto(schedule), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getSchedules(@PathVariable("group-id") Long groupId,
                                       @RequestParam @Positive int page,
                                       @RequestParam @Positive int size) {
        Group group = groupService.findGroup(groupId);
        Page<Schedule> schedules = scheduleService.findSchedules(group, page - 1, size);
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

    @GetMapping("/{schedule-id}")
    public ResponseEntity getSchedule(@PathVariable("group-id") Long groupId,
                                      @PathVariable("schedule-id") Long scheduleId) {
        Schedule schedule = scheduleService.findSchedule(scheduleId);
        return new ResponseEntity<>(scheduleMapper.scheduleToScheduleRequestDto(schedule), HttpStatus.OK);
    }

    @DeleteMapping("/{schedule-id}")
    public ResponseEntity deleteSchedule(@PathVariable("group-id") Long groupId,
                                         @PathVariable("schedule-id") Long scheduleId) {
        scheduleService.deleteSchedule(scheduleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{schedule-id}")
    public ResponseEntity patchSchedule(@PathVariable("group-id") Long groupId,
                                        @PathVariable("schedule-id") Long scheduleId,
                                        @RequestBody SchedulePatchDto requestBody) {
        requestBody.setScheduleId(scheduleId);
        Schedule patchSchedule = scheduleService.patchSchedule(scheduleMapper.schedulePatchDtoToSchedule(requestBody));
        return new ResponseEntity<>(scheduleMapper.scheduleToScheduleRequestDto(patchSchedule), HttpStatus.OK);
    }
}
