package com.study.group.entity;

import com.study.audit.Auditable;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity(name = "Groups") //예약어로인한 name 변경
public class Group extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;

    @Column(nullable = false)
    private String teamName;

}
