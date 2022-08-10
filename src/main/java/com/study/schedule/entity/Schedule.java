package com.study.schedule.entity;

import com.study.group.entity.Group;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long scheduleId;

    @ManyToOne
    @JoinColumn(name = "groupId")
    private Group group;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private LocalDateTime startDate = LocalDateTime.now();

    private LocalDateTime finishDate = LocalDateTime.now();
}