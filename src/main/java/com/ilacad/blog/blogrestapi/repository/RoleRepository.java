package com.ilacad.blog.blogrestapi.repository;

import com.ilacad.blog.blogrestapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<User, Long> {
}