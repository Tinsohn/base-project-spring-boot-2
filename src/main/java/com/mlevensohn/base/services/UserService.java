package com.mlevensohn.base.services;

import com.mlevensohn.base.models.RegisterRequest;
import com.mlevensohn.base.models.UserDto;

public interface UserService {

    UserDto findByUsername(String username);

    UserDto save(RegisterRequest user);

}
