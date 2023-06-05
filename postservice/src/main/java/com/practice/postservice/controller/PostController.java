package com.practice.postservice.controller;

import com.practice.postservice.model.Post;
import com.practice.postservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Optional<Post> post = postService.findById(id);
        if (!post.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(post.get());
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody @Validated Post post) {
        return ResponseEntity.ok(postService.save(post));
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePostById(@PathVariable Long id, @RequestBody @Validated Post updatedPost) {
        Optional<Post> existingPost = postService.findById(id);
        if (!existingPost.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Post modifiedPost = existingPost.get();
        modifiedPost.setTextOfPost(updatedPost.getTextOfPost());
        modifiedPost.setPostedAt(updatedPost.getPostedAt());
        modifiedPost.setAuthorId(updatedPost.getAuthorId());
        modifiedPost.setTopic(updatedPost.getTopic());
        return ResponseEntity.ok(postService.save(modifiedPost)); // return 200 if post is updated successfully
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Void> deletePostById(@PathVariable Long id) {
        boolean isDeleted = postService.deleteById(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
