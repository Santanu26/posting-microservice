package com.practice.postservice.service;

import com.practice.postservice.model.Post;
import com.practice.postservice.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final RestTemplate restTemplate;
    @Value("${service.user.url}")
    private String USER_SERVICE_URL;

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post save(Post post) {
        Post newPost = postRepository.save(post);
        incrementNoOfPostCount(newPost.getAuthorId());
        return newPost;
    }

    @Override
    public boolean deleteById(Long id) {
        postRepository.deleteById(id);
        decrementNoOfPostCount(id);
        return true;
    }

    private void incrementNoOfPostCount(Long authorId) {
        if (USER_SERVICE_URL == null) {
            throw new IllegalStateException("USER_SERVICE_URL not set");
        }
        String url = USER_SERVICE_URL + "/users/" + authorId + "/post-count/increment";
        try {
            ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.PUT, HttpEntity.EMPTY, Void.class);
            if (response.getStatusCode() != HttpStatus.OK) {
                throw new RuntimeException("Failed to increment post count");
            }
        } catch (RestClientException e) {
            throw new RuntimeException("Failed to increment post count", e);
        }
    }

    private void decrementNoOfPostCount(Long authorId) {
        if (USER_SERVICE_URL == null) {
            throw new IllegalStateException("USER_SERVICE_URL not set");
        }
        String url = USER_SERVICE_URL + "/users/" + authorId + "/post-count/decrement";
        try {
            ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.DELETE, HttpEntity.EMPTY, Void.class);
            if (response.getStatusCode() != HttpStatus.OK) {
                throw new RuntimeException("Failed to decrement post count");
            }
        } catch (RestClientException e) {
            throw new RuntimeException("Failed to decrement post count", e);
        }
    }
}
