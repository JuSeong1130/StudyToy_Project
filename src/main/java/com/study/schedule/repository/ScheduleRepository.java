package com.study.schedule.repository;

import com.study.group.entity.Group;
import com.study.schedule.entity.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    public Page<Schedule> findAllByGroup(Group group, Pageable pageable);
}
