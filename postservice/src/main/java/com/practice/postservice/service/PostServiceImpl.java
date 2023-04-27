package com.practice.postservice.service;

import com.practice.postservice.Post;
import com.practice.postservice.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@Transactional
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final RestTemplate restTemplate;
    @Value("${service.user.url}")
    private String USER_SERVICE_URL;
    public PostServiceImpl(PostRepository postRepository, RestTemplate restTemplate) {
        this.postRepository = postRepository;
        this.restTemplate = restTemplate;
    }
    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }
    @Override
    public Post save(Post post) {
        Post newPost = postRepository.save(post);
        incrementNoOfPosts(newPost.getAuthorId());
        return newPost;
    }
    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
        decrementNoOfPosts(id);
    }
    private void incrementNoOfPosts(Long authorId) {
        String url = USER_SERVICE_URL + "/users/increment-post/" + authorId;
        restTemplate.postForObject(url, HttpEntity.EMPTY, String.class);
    }
    private void decrementNoOfPosts(Long authorId) {
        String url = USER_SERVICE_URL + "/users/decrement-post/" + authorId;
        restTemplate.postForObject(url, HttpEntity.EMPTY, String.class);
    }
}
