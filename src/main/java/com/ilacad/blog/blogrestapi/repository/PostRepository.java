package com.ilacad.blog.blogrestapi.repository;

import com.ilacad.blog.blogrestapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByCategory_id(Long categoryId);
}
