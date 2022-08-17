package com.study.group.repository;

import com.study.group.entity.ApplyGroup;
import com.study.group.entity.MemberGroup;
import com.study.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberGroupRepository extends JpaRepository<MemberGroup, Long> {
    public Optional<MemberGroup> findByMember(Member member);
}
