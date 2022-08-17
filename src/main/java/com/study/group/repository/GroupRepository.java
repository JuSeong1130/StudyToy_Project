package com.study.group.repository;

import com.study.group.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {
    public Optional<Group> findByTeamName(String teamName);
}
