package com.ilacad.blog.blogrestapi.service.impl;

import com.ilacad.blog.blogrestapi.entity.Category;
import com.ilacad.blog.blogrestapi.exception.ResourceNotFoundException;
import com.ilacad.blog.blogrestapi.mapper.CategoryMapper;
import com.ilacad.blog.blogrestapi.payload.CategoryDto;
import com.ilacad.blog.blogrestapi.repository.CategoryRepository;
import com.ilacad.blog.blogrestapi.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.INSTANCE.categoryDtoToCategory(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.INSTANCE.categoryToCategoryDto(savedCategory);
    }

    @Override
    public CategoryDto getCategory(Long categoryId) {
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
        return CategoryMapper.INSTANCE.categoryToCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(category ->
                        CategoryMapper.INSTANCE.categoryToCategoryDto(category))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId) {
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        category.setId(categoryDto.getId());

        categoryRepository.save(category);
        return CategoryMapper.INSTANCE.categoryToCategoryDto(category);
    }
}
