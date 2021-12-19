package com.api.orange.controllers.impl;

import com.api.orange.controllers.UserController;
import com.api.orange.models.User;
import com.api.orange.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserControllerImpl implements UserController {
    @Autowired
    UserService userService;

    @Override
    public ResponseEntity getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    public ResponseEntity getUser(String cpf) {
        return userService.getUser(cpf);
    }

    @Override
    public ResponseEntity saveUser(User user) {
        return userService.saveUser(user);
    }

    @Override
    public ResponseEntity updateUser(String cpf, User user) {
        return userService.updateUser(cpf, user);
    }

    @Override
    public ResponseEntity deleteUser(String cpf) {
        return userService.deleteUser(cpf);
    }
}
