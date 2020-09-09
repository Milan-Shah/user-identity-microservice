package com.shah.photo.api.users.usersmicroservice.controller;


import com.shah.photo.api.users.usersmicroservice.entity.User;
import com.shah.photo.api.users.usersmicroservice.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(path = "/users")
public class UsersController {

    @Autowired
    private Environment env;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(path = "/status")
    public ResponseEntity status() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
    produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity createUser(@Valid @RequestBody User user) {
        user.setUserId(UUID.randomUUID().toString());
        this.userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping
    public Iterable<User> findAll() {
        return this.userService.findAll();
    }

//    @PostMapping(path = "/login2")
//    public ResponseEntity performUserLoginRequest(@RequestBody LoginRequestModel requestModel) {
//        User userFromDB = this.userService.findByEmail(requestModel.getEmail());
//        return ResponseEntity.status(HttpStatus.OK).body(userFromDB);
//    }
}
