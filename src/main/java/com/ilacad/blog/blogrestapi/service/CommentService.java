package com.ilacad.blog.blogrestapi.service;

import com.ilacad.blog.blogrestapi.payload.CommentDto;

import java.util.List;

public interface CommentService {

    CommentDto createComment(Long postId, CommentDto commentDto);

    List<CommentDto> getCommentsByPostId(Long postId);
}
