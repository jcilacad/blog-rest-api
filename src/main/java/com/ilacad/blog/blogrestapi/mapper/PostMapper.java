package com.ilacad.blog.blogrestapi.mapper;

import com.ilacad.blog.blogrestapi.entity.Post;
import com.ilacad.blog.blogrestapi.payload.PostDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    Post postDtoToPost(PostDto postDto);

    PostDto postToPostDto(Post post);
}
