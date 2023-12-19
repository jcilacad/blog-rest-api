package com.ilacad.blog.blogrestapi.service.impl;

import com.ilacad.blog.blogrestapi.entity.Category;
import com.ilacad.blog.blogrestapi.mapper.CategoryMapper;
import com.ilacad.blog.blogrestapi.payload.CategoryDto;
import com.ilacad.blog.blogrestapi.repository.CategoryRepository;
import com.ilacad.blog.blogrestapi.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {

        // Convert category dto to entity
        Category category = CategoryMapper.INSTANCE.categoryDtoToCategory(categoryDto);

        // Save the category in database
        Category savedCategory = categoryRepository.save(category);

        return CategoryMapper.INSTANCE.categoryToCategoryDto(savedCategory);
    }
}
