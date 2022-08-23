package com.study.schedule.entity;

import com.study.group.entity.Group;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long scheduleId;

    @Setter
    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    @Setter
    @Column(nullable = false)
    private String title;

    @Setter
    @Column(nullable = false)
    private String contents;

    @Setter
    private LocalDateTime startDate = LocalDateTime.now();

    @Setter
    private LocalDateTime finishDate = LocalDateTime.now();

    @Builder
    public Schedule(Long scheduleId, Group group, String title, String contents, LocalDateTime startDate, LocalDateTime finishDate) {
        this.scheduleId = scheduleId;
        this.group = group;
        this.title = title;
        this.contents = contents;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }
}