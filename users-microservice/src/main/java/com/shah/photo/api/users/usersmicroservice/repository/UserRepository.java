package com.shah.photo.api.users.usersmicroservice.repository;

import com.shah.photo.api.users.usersmicroservice.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
