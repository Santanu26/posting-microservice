package com.practice.userService.controller;

import com.practice.userService.User;
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
    public String greeting() {
        return "Hello, k8s!";
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Validated @RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable Long id, @Validated @RequestBody User updatedUser) {
        Optional<User> existingUser = userService.findById(id);

        if (existingUser.isPresent()) {
            User modifiedUser = existingUser.get();
            modifiedUser.setUsername(updatedUser.getUsername());

            return ResponseEntity.ok(userService.save(modifiedUser));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
