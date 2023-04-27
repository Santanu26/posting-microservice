package com.practice.userService.controller;

import com.practice.userService.model.User;
import com.practice.userService.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetUserById() {
        Long id = 1L;
        User user = new User();
        user.setId(id);
        Mockito.when(userService.findById(id)).thenReturn(Optional.of(user));

        ResponseEntity<User> response = userController.getUserById(id);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());

        Mockito.when(userService.findById(id)).thenReturn(Optional.empty());
        response = userController.getUserById(id);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}

