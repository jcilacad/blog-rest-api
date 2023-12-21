package com.ilacad.blog.blogrestapi.service;

import com.ilacad.blog.blogrestapi.payload.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto addCategory(CategoryDto categoryDto);

    CategoryDto getCategory(Long categoryId);

    List<CategoryDto> getCategories();

    CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId);
}
