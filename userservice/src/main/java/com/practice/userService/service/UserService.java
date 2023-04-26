package com.practice.userService.service;

import com.practice.userService.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findById(Long id);

    User save(User user);

    void deleteById(Long id);

    void incrementPosts(Long id);
    void decrementPosts(Long id);
}
