package com.study.group.repository;

import com.study.group.entity.ApplyGroup;
import com.study.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplyGroupRepository extends JpaRepository<ApplyGroup, Long> {
}
