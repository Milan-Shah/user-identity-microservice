package com.shah.photo.api.users.usersmicroservice.controller;


import com.shah.photo.api.users.usersmicroservice.entity.User;
import com.shah.photo.api.users.usersmicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping(path = "/users")
public class UsersController {

    @Autowired
    private Environment env;

    @Autowired
    private UserService userService;

    @GetMapping(path = "/status")
    public ResponseEntity status() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createUser(@Valid @RequestBody User user) {
        this.userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping
    public Iterable<User> findAll() {
        return this.userService.findAll();
    }
}
