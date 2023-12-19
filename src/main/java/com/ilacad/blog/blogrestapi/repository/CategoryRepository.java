package com.ilacad.blog.blogrestapi.repository;

import com.ilacad.blog.blogrestapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
