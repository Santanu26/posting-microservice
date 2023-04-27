package com.practice.postservice.controller;

import com.practice.postservice.Post;
import com.practice.postservice.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postRepository) {
        this.postService = postRepository;
    }

    @GetMapping("/greeting")
    public String greeting() {
        return "Hello, k8s!";
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Optional<Post> post = postService.findById(id);
        if (post.isPresent()) {
            return ResponseEntity.ok(post.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(postService.save(post));
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePostById(@PathVariable Long id, @RequestBody Post updatedPost) {
        Optional<Post> existingPost = postService.findById(id);

        if (existingPost.isPresent()) {
            Post modifiedPost = existingPost.get();
            modifiedPost.setTextOfPost(updatedPost.getTextOfPost());
            return ResponseEntity.ok(postService.save(modifiedPost));
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Void> deletePostById(@PathVariable Long id) {
        postService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
