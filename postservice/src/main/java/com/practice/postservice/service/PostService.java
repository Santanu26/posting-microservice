package com.practice.postservice.service;

import com.practice.postservice.model.Post;

import java.util.Optional;

public interface PostService {

    Optional<Post> findById(Long id);

    Post save(Post post);

    void deleteById(Long id);
}
