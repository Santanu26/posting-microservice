package com.practice.userService.service;

import com.practice.userService.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findById(Long id);

    User save(User user);

    void deleteById(Long id);

    User incrementPosts(Long id);
    User decrementPosts(Long id);
}
