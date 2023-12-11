package com.ilacad.blog.blogrestapi.service.impl;

import com.ilacad.blog.blogrestapi.entity.Comment;
import com.ilacad.blog.blogrestapi.entity.Post;
import com.ilacad.blog.blogrestapi.exception.BlogApiException;
import com.ilacad.blog.blogrestapi.exception.ResourceNotFoundException;
import com.ilacad.blog.blogrestapi.mapper.CommentMapper;
import com.ilacad.blog.blogrestapi.payload.CommentDto;
import com.ilacad.blog.blogrestapi.repository.CommentRepository;
import com.ilacad.blog.blogrestapi.repository.PostRepository;
import com.ilacad.blog.blogrestapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;


    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDto createComment(Long postId, CommentDto commentDto) {
        Comment comment = CommentMapper.INSTANCE.commentDtoToComment(commentDto);

        // Retrieve post by id
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", postId));

        // Set the comment post
        comment.setPost(post);

        // Save the new comment to database
        Comment newComment = commentRepository.save(comment);

        return CommentMapper.INSTANCE.commentToCommentDto(newComment);
    }

    @Override
    public List<CommentDto> getCommentsByPostId(Long postId) {
        // Retrieve a list of comments by post id
        List<Comment> comments = commentRepository.findByPostId(postId);

        return comments.stream().map(comment -> CommentMapper.INSTANCE.commentToCommentDto(comment)).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(Long postId, Long commentId) {
        Comment comment = validateComment(postId, commentId);
        return CommentMapper.INSTANCE.commentToCommentDto(comment);
    }

    @Override
    public CommentDto updateComment(Long postId, Long commentId, CommentDto commentDto) {
        Comment comment = validateComment(postId, commentId);

        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());

        // Save it in database
        Comment updatedComment = commentRepository.save(comment);

        return CommentMapper.INSTANCE.commentToCommentDto(updatedComment);
    }

    @Override
    public void deleteComment(Long postId, Long commentId) {
        Comment comment = validateComment(postId, commentId);
        commentRepository.delete(comment);
    }


    private Comment validateComment(Long postId, Long commentId) {
        // Retrieve the post by postId
        Post post = postRepository.findById(postId).orElseThrow(() ->
                new ResourceNotFoundException("Post", "id", postId));

        // Retrieve comment by commentId
        Comment comment = commentRepository.findById(commentId).orElseThrow(() ->
                new ResourceNotFoundException("Comment", "id", commentId));

        // Validate if the comment belongs to a post
        if (!comment.getPost().getId().equals(post.getId())) {
            throw new BlogApiException(HttpStatus.BAD_REQUEST, "Comment does not belong to a post");
        }

        return comment;
    }

}
