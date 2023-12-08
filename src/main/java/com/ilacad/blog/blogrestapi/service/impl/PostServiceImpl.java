package com.ilacad.blog.blogrestapi.service.impl;

import com.ilacad.blog.blogrestapi.entity.Post;
import com.ilacad.blog.blogrestapi.exception.ResourceNotFoundException;
import com.ilacad.blog.blogrestapi.payload.PostDto;
import com.ilacad.blog.blogrestapi.payload.PostResponse;
import com.ilacad.blog.blogrestapi.repository.PostRepository;
import com.ilacad.blog.blogrestapi.service.PostService;
import com.zaxxer.hikari.metrics.PoolStats;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public PostResponse getAllPosts(int pageNo, int pageSize) {

        // Create an instance of Pageable
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        // Get all posts in db
        Page<Post> posts = postRepository.findAll(pageable);

        // Convert page to list
        List<Post> pageList = posts.getContent();

        // Convert post entity to dto
        List<PostDto> content =  pageList.stream().map(post -> mapToDto(post)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();

        postResponse.setContent(content);
        postResponse.setPageNo(posts.getNumber());
        postResponse.setPageSize(posts.getSize());
        postResponse.setTotalElement(posts.getTotalElements());
        postResponse.setTotalPages(posts.getTotalPages());
        postResponse.setLast(posts.isLast());

        return postResponse;
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

    @Override
    public PostDto updatePost(PostDto postDto, Long id) {

        // Get the post by id
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        // Update the post based on the post dto
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        // Save it in database
        Post updatedPost = postRepository.save(post);

        return mapToDto(updatedPost);
    }

    @Override
    public void deletePostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        postRepository.delete(post);
    }
}
