package com.api.orange.controllers;

import com.api.orange.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface UserController {

    @GetMapping()
    public ResponseEntity getAllUsers();

    @GetMapping(path = "/{cpf}")
    public ResponseEntity getUser(String cpf);

    @PostMapping()
    public ResponseEntity saveUser(@RequestBody User user);

    @PutMapping(path = "/{cpf}")
    public ResponseEntity updateUser(String cpf, @RequestBody User user);

    @DeleteMapping(path = "/{cpf}")
    public ResponseEntity deleteUser(String cpf);

}
