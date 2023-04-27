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
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public User incrementPosts(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            int count = Integer.parseInt(user.getAmountOfPosts());
            user.setAmountOfPosts(String.valueOf(count++));
            return userRepository.save(user);
        } else {
            throw new NoSuchElementException("NO user found for the id: " + id);
        }
    }

    @Override
    public User decrementPosts(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (!optionalUser.isPresent()) {
            throw new NoSuchElementException("NO user found for the id: " + id);
        }

        User user = optionalUser.get();
        int count = Integer.parseInt(user.getAmountOfPosts());
        user.setAmountOfPosts(String.valueOf(count--));
        return userRepository.save(user);
    }
}
