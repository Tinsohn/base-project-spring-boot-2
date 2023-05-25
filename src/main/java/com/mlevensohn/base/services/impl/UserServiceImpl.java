package com.mlevensohn.base.services.impl;

import com.mlevensohn.base.entities.Role;
import com.mlevensohn.base.entities.User;
import com.mlevensohn.base.exception.EmailAlreadyExistsException;
import com.mlevensohn.base.exception.UsernameAlreadyExistsException;
import com.mlevensohn.base.mappers.RequestMapper;
import com.mlevensohn.base.mappers.UserMapper;
import com.mlevensohn.base.models.RegisterRequest;
import com.mlevensohn.base.models.UserDto;
import com.mlevensohn.base.repositories.UserRepository;
import com.mlevensohn.base.services.RoleService;
import com.mlevensohn.base.services.UserService;
import com.mlevensohn.base.utils.RoleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto findByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Invalid username or password."));
        return UserMapper.INSTANCE.entityToDto(user);
    }

    @Override
    public UserDto save(RegisterRequest registerRequest) {
        User nUser = RequestMapper.INSTANCE.registerRequestToUser(registerRequest);

        if (userRepository.existsByUsername(nUser.getUsername()))
            throw new UsernameAlreadyExistsException("Error: Username is already taken!");

        if(userRepository.existsByEmail(nUser.getEmail()))
            throw new EmailAlreadyExistsException("Error: Email is already in use!");

        nUser.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        Role role = roleService.findByName(RoleEnum.USER);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        if (nUser.getEmail().split("@")[1].equals("admin.com")) {
            role = roleService.findByName(RoleEnum.ADMIN);
            roleSet.add(role);
        }

        nUser.setRoles(roleSet);

        User user = userRepository.save(nUser);

        return UserMapper.INSTANCE.entityToDto(user);
    }
}
