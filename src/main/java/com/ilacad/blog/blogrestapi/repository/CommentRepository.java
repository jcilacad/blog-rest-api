package com.ilacad.blog.blogrestapi.repository;

import com.ilacad.blog.blogrestapi.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
