package com.api.orange.services;

import com.api.orange.models.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity getAllUsers();

    ResponseEntity getUser(String cpf);

    ResponseEntity saveUser(User user);

    ResponseEntity updateUser(String cpf, User user);

    ResponseEntity deleteUser(String cpf);
}
