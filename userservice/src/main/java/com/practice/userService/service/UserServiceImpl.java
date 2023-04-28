package com.practice.userService.service;

import com.practice.userService.model.User;
import com.practice.userService.respository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean deleteById(Long id) {
        userRepository.deleteById(id);
        return true;
    }

    @Override
    @Transactional
    public User incrementPostCount(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new NoSuchElementException("User not found for the given id: " + id);
        }

        User user = optionalUser.get();
        int count = Integer.parseInt(user.getAmountOfPosts());
        user.setAmountOfPosts(String.valueOf(++count));
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User decrementPostCount(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new NoSuchElementException("User not found for the given id: " + id);
        }

        User user = optionalUser.get();
        int count = Integer.parseInt(user.getAmountOfPosts());
        user.setAmountOfPosts(String.valueOf(--count));
        return userRepository.save(user);
    }
}
