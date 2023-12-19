package com.ilacad.blog.blogrestapi.mapper;

import com.ilacad.blog.blogrestapi.entity.Category;
import com.ilacad.blog.blogrestapi.payload.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category categoryDtoToCategory(CategoryDto categoryDto);

    CategoryDto categoryToCategoryDto(Category category);
}
