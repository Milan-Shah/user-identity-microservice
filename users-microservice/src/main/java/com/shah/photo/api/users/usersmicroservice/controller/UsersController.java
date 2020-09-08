package com.shah.photo.api.users.usersmicroservice.controller;


import com.shah.photo.api.users.usersmicroservice.entity.User;
import com.shah.photo.api.users.usersmicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
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

    @PostMapping(consumes = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
    produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity createUser(@Valid @RequestBody User user) {
        this.userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping
    public Iterable<User> findAll() {
        return this.userService.findAll();
    }
}
