package com.mlevensohn.base.controllers;

import com.mlevensohn.base.models.UserDto;
import com.mlevensohn.base.models.LoginRequest;
import com.mlevensohn.base.models.RegisterRequest;
import com.mlevensohn.base.models.AuthResponse;
import com.mlevensohn.base.entities.User;
import com.mlevensohn.base.mappers.UserMapper;
import com.mlevensohn.base.security.jwt.JwtUtils;
import com.mlevensohn.base.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtUtils jwtUtils;

    public AuthController(AuthenticationManager authenticationManager,
                          UserService userService,
                          JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        AuthResponse response = this.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest signUpRequest) {
        userService.save(signUpRequest);
        AuthResponse response = this.authenticate(signUpRequest.getUsername(), signUpRequest.getPassword());
        return ResponseEntity.ok(response);
    }

    private AuthResponse authenticate(String username, String password) {
        final Authentication authentication = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                username,
                                password));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String jwt = jwtUtils.generateToken(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        User user = userService.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Invalid username or password."));
        UserDto userDTO = UserMapper.INSTANCE.entityToDto(user);

        return AuthResponse.builder()
                .user(userDTO)
                .accessToken(jwt)
                .build();
    }

}

