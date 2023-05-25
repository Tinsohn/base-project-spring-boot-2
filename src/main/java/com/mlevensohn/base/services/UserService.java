package com.mlevensohn.base.services;

import com.mlevensohn.base.entities.User;
import com.mlevensohn.base.models.RegisterRequest;

import java.util.Optional;

public interface UserService {

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    User save(RegisterRequest user);

}
