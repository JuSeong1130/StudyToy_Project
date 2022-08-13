package com.study.group.repository;

import com.study.group.entity.MemberGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberGroupRepository extends JpaRepository<MemberGroup, Long> {
}
