package com.study.schedule.service;

import com.study.exception.BusinessLogicException;
import com.study.exception.ExceptionCode;
import com.study.group.entity.Group;
import com.study.group.service.GroupService;
import com.study.schedule.entity.Schedule;
import com.study.schedule.repository.ScheduleRepository;
import com.study.utils.CustomBeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScheduleService {
    private ScheduleRepository scheduleRepository;
    private CustomBeanUtils<Schedule> beanUtils;

    public ScheduleService(ScheduleRepository scheduleRepository, CustomBeanUtils<Schedule> beanUtils) {
        this.scheduleRepository = scheduleRepository;
        this.beanUtils = beanUtils;
    }

    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public Page<Schedule> findSchedules(Group group, int page, int size) {
        return scheduleRepository.findAllByGroup(group, PageRequest.of(page, size, Sort.by("scheduleId").descending()));
    }

    public Schedule findSchedule(Long scheduleId) {
        return findVerifiedSchedule(scheduleId);
    }

    public void deleteSchedule(Long scheduleId) {
        Schedule schedule = findVerifiedSchedule(scheduleId);
        scheduleRepository.delete(schedule);
    }

    public Schedule patchSchedule(Schedule schedule) {
        Schedule findSchedule = findSchedule(schedule.getScheduleId());
        return scheduleRepository.save(beanUtils.copyNonNullProperties(schedule, findSchedule));
    }

    private Schedule findVerifiedSchedule(Long scheduleId) {
        return scheduleRepository.findById(scheduleId).orElseThrow(() -> new BusinessLogicException(ExceptionCode.SCHEDULE_NOT_FOUND));
    }
}
