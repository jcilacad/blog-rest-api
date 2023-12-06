package com.ilacad.blog.blogrestapi.service.impl;

import com.ilacad.blog.blogrestapi.entity.Post;
import com.ilacad.blog.blogrestapi.exception.ResourceNotFoundException;
import com.ilacad.blog.blogrestapi.payload.PostDto;
import com.ilacad.blog.blogrestapi.repository.PostRepository;
import com.ilacad.blog.blogrestapi.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        Post post = mapToEntity(postDto);
        // Save the post to database
        Post newPost = postRepository.save(post);

        PostDto postResponse = mapToDto(newPost);

        return postResponse;
    }

    @Override
    public List<PostDto> getAllPosts() {

        // Get all posts in db
        List<Post> posts = postRepository.findAll();

        // Convert post entity to dto
        return posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
    }

    // Convert entity to dto
    private PostDto mapToDto(Post post) {

        PostDto postDto = new PostDto(
                post.getId(),
                post.getTitle(),
                post.getDescription(),
                post.getContent()
        );

        return postDto;
    }

    // Convert the DTO to entity
    private Post mapToEntity(PostDto postDto) {

        Post post = new Post(
                postDto.getId(),
                postDto.getTitle(),
                postDto.getDescription(),
                postDto.getContent()
        );

        return post;
    }

    @Override
    public PostDto getPostById(Long id) {

        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return mapToDto(post);
    }
}
