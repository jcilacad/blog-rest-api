package com.ilacad.blog.blogrestapi.repository;

import com.ilacad.blog.blogrestapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
