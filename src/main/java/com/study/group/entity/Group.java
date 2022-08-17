package com.study.group.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.study.audit.Auditable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity(name = "Groups") //예약어로인한 name 변경
@NoArgsConstructor
public class Group extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;

    @Setter
    @Column(nullable = false)
    private String teamName;

    @JsonManagedReference
    @OneToMany(mappedBy = "group", cascade = CascadeType.REMOVE)
    private final List<MemberGroup> memberGroup = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "group", cascade = CascadeType.REMOVE)
    private final List<ApplyGroup> applyGroups = new ArrayList<>();

    @Builder
    public Group(Long groupId, String teamName) {
        this.groupId = groupId;
        this.teamName = teamName;
    }
}
