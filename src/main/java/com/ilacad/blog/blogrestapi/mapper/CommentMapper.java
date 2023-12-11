package com.ilacad.blog.blogrestapi.mapper;

import com.ilacad.blog.blogrestapi.entity.Comment;
import com.ilacad.blog.blogrestapi.payload.CommentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    Comment commentDtoToComment(CommentDto commentDto);
    CommentDto commentToCommentDto(Comment comment);
}
