package com.study.comments.repository;

import com.study.comments.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments,Long> {
}
