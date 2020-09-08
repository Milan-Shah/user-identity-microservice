package com.shah.photo.api.users.usersmicroservice.service;

import com.shah.photo.api.users.usersmicroservice.entity.User;
import com.shah.photo.api.users.usersmicroservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void createUser(User user) {
        String encryptedPassword = this.bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        this.userRepository.save(user);
    }

    public Iterable<User> findAll() {
        return this.userRepository.findAll();
    }
}
