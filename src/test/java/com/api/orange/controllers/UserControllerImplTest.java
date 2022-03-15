package com.api.orange.controllers;

import com.api.orange.models.User;
import com.api.orange.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserControllerImplTest {


    private User userSetup() {
        User user = new User(1L, "Gustavo", "943.142.730-38", "gustavo@gmail.com", new Date());
        return user;
    }

    private List<User> listUserSetup() {
        List<User> users = Arrays.asList(userSetup());
        return users;
    }

    private UserService userServiceSetup() {
        UserService userService = mock(UserService.class);
        ResponseEntity responseEntity = new ResponseEntity(listUserSetup(), HttpStatus.ACCEPTED);
        when(userService.getAllUsers()).thenReturn(responseEntity);
        return userService;
    }

    @Test
    public void userSeriveGetAllUsers() {
        UserService userService = userServiceSetup();
        ResponseEntity responseEntityResult = userService.getAllUsers();
        assertEquals(HttpStatus.ACCEPTED, responseEntityResult.getStatusCode());
    }

}