package com.study.group.entity;

import javax.persistence.*;

@Entity(name = "GROUPS")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long groupId;

    @Column(nullable = false)
    private String teamName;
}
