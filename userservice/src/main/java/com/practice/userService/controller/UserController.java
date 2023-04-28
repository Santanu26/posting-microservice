package com.practice.userService.controller;

import com.practice.userService.model.User;
import com.practice.userService.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/greeting")
    public ResponseEntity<String> greeting() {
        return ResponseEntity.ok("Hello, k8s!");
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        if (!user.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user.get());
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody @Validated User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable Long id, @Validated @RequestBody User updatedUser) {
        Optional<User> existingUser = userService.findById(id);
        if (!existingUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        User modifiedUser = existingUser.get();
        modifiedUser.setUsername(updatedUser.getUsername());

        return ResponseEntity.ok(userService.save(modifiedUser));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        boolean isDeleted = userService.deleteById(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/users/{id}/post-count/increment")
    public ResponseEntity<User> incrementPostCount(@PathVariable Long id) {
        return ResponseEntity.ok(userService.incrementPostCount(id));
    }

    @PutMapping("/users/{id}/post-count/decrement")
    public ResponseEntity<User> decrementPostCount(@PathVariable Long id) {
        return ResponseEntity.ok(userService.decrementPostCount(id));
    }
}
