package com.ilacad.blog.blogrestapi.service;

import com.ilacad.blog.blogrestapi.payload.CommentDto;

public interface CommentService {

    CommentDto createComment(Long postId, CommentDto commentDto);
}
