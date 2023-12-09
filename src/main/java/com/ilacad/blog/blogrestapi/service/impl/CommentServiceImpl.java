package com.ilacad.blog.blogrestapi.service.impl;

import com.ilacad.blog.blogrestapi.entity.Comment;
import com.ilacad.blog.blogrestapi.payload.CommentDto;
import com.ilacad.blog.blogrestapi.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Override
    public CommentDto createComment(Long postId, CommentDto commentDto) {

        return null;
    }

    private CommentDto mapToDto(Comment comment) {

        CommentDto commentDto = new CommentDto(
                comment.getId(),
                comment.getName(),
                comment.getEmail(),
                comment.getBody()
        );

        return commentDto;
    }

    private Comment mapToEntity(CommentDto commentDto) {

        Comment comment = new Comment(
                commentDto.getId(),
                commentDto.getName(),
                commentDto.getEmail(),
                commentDto.getBody()
        );
        
        return comment;

    }
}
