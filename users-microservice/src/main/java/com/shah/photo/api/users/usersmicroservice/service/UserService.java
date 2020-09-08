package com.shah.photo.api.users.usersmicroservice.service;

import com.shah.photo.api.users.usersmicroservice.entity.User;
import com.shah.photo.api.users.usersmicroservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        this.userRepository.save(user);
    }

    public Iterable<User> findAll() {
        return this.userRepository.findAll();
    }
}
