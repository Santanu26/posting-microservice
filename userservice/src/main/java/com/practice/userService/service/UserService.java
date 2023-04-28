package com.practice.userService.service;

import com.practice.userService.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findById(Long id);

    User save(User user);

    boolean deleteById(Long id);

    User incrementPostCount(Long id);

    User decrementPostCount(Long id);
}
