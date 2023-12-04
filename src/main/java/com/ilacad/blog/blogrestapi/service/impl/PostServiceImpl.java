package com.ilacad.blog.blogrestapi.service.impl;

import com.ilacad.blog.blogrestapi.entity.Post;
import com.ilacad.blog.blogrestapi.payload.PostDto;
import com.ilacad.blog.blogrestapi.repository.PostRepository;
import com.ilacad.blog.blogrestapi.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        // Convert the DTO to entity
        Post post = new Post(
                postDto.getId(),
                postDto.getTitle(),
                postDto.getDescription(),
                postDto.getContent()
        );

        // Save the post to database
        Post newPost = postRepository.save(post);

        // Convert entity to DTO
        PostDto postResponse = new PostDto(
                newPost.getId(),
                newPost.getTitle(),
                newPost.getDescription(),
                newPost.getContent()
        );

        return postResponse;
    }
}
