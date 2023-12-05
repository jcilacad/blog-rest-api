package com.ilacad.blog.blogrestapi.service;

import com.ilacad.blog.blogrestapi.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPosts();
}
