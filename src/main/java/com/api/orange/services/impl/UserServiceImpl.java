package com.api.orange.services.impl;

import com.api.orange.models.User;
import com.api.orange.repositories.UserRepository;
import com.api.orange.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity getAllUsers() {
        List<User> users;
        try {
            users = userRepository.findAll();
            return new ResponseEntity(users, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity getUser(String cpf) {
        User user;
        try {
            user = userRepository.findByCpf(cpf);
            if(user == null){
                return new ResponseEntity("Not Found", HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity(user, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity saveUser(User user) {
        try {
            if (Objects.isNull(user)) {
                return new ResponseEntity("Error: User is cannot be null", HttpStatus.PRECONDITION_FAILED);
            }

            userRepository.save(user);

            return new ResponseEntity("User saved!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity updateUser(String cpf, User user) {
        try {
            if (Objects.isNull(user)) {
                return new ResponseEntity("Error: User is cannot be null", HttpStatus.PRECONDITION_FAILED);
            }

            if (Objects.isNull(userRepository.findByCpf(cpf))) {
                return new ResponseEntity("Error: User not found", HttpStatus.NOT_FOUND);
            }

            userRepository.saveAndFlush(user);

            return new ResponseEntity("User saved!", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity deleteUser(String cpf) {
        User user;
        try {
            user = userRepository.findByCpf(cpf);

            if (Objects.isNull(user)) {
                return new ResponseEntity("Error: User not found", HttpStatus.NOT_FOUND);
            }

            userRepository.deleteById(user.getId());

            return new ResponseEntity("User saved!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
