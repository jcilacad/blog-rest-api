package com.ilacad.blog.blogrestapi.service.impl;

import com.ilacad.blog.blogrestapi.entity.Post;
import com.ilacad.blog.blogrestapi.exception.ResourceNotFoundException;
import com.ilacad.blog.blogrestapi.mapper.PostMapper;
import com.ilacad.blog.blogrestapi.payload.PostDto;
import com.ilacad.blog.blogrestapi.payload.PostResponse;
import com.ilacad.blog.blogrestapi.repository.PostRepository;
import com.ilacad.blog.blogrestapi.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private PostMapper postMapper;

    public PostServiceImpl(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        Post post = postMapper.INSTANCE.postDtoToPost(postDto);
        // Save the post to database
        Post newPost = postRepository.save(post);

        PostDto postResponse = postMapper.INSTANCE.postToPostDto(newPost);

        return postResponse;
    }

    @Override
    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {

        // Condition for sorting direction
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        // Create an instance of Pageable
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        // Get all posts in db
        Page<Post> posts = postRepository.findAll(pageable);

        // Convert page to list
        List<Post> pageList = posts.getContent();

        // Convert post entity to dto
        List<PostDto> content =  pageList.stream().map(post -> postMapper.INSTANCE.postToPostDto(post)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();

        postResponse.setContent(content);
        postResponse.setPageNo(posts.getNumber());
        postResponse.setPageSize(posts.getSize());
        postResponse.setTotalElement(posts.getTotalElements());
        postResponse.setTotalPages(posts.getTotalPages());
        postResponse.setLast(posts.isLast());

        return postResponse;
    }

    @Override
    public PostDto getPostById(Long id) {

        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return postMapper.INSTANCE.postToPostDto(post);
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

        return postMapper.INSTANCE.postToPostDto(updatedPost);
    }

    @Override
    public void deletePostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        postRepository.delete(post);
    }
}
