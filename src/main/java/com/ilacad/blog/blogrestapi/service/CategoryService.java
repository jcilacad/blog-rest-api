package com.ilacad.blog.blogrestapi.service;

import com.ilacad.blog.blogrestapi.payload.CategoryDto;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {

    CategoryDto addCategory(CategoryDto categoryDto);
}
