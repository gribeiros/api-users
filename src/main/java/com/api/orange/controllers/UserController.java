package com.api.orange.controllers;

import com.api.orange.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface UserController {

    @GetMapping(path = "/users")
    public ResponseEntity getAllUsers();

    @GetMapping(path = "/user/{cpf}")
    public ResponseEntity getUser(@PathVariable  String cpf);

    @PostMapping(path = "/user")
    public ResponseEntity saveUser(@RequestBody User user);

    @PutMapping(path = "/user/{cpf}")
    public ResponseEntity updateUser(@PathVariable String cpf, @RequestBody User user);

    @DeleteMapping(path = "/user/{cpf}")
    public ResponseEntity deleteUser(@PathVariable String cpf);

}
