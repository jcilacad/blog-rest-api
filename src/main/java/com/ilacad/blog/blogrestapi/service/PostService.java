package com.ilacad.blog.blogrestapi.service;

import com.ilacad.blog.blogrestapi.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);
}
