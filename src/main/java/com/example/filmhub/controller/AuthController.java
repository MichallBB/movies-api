package com.example.filmhub.controller;

import com.example.filmhub.DTO.AuthResponseDTO;
import com.example.filmhub.DTO.LoginDto;
import com.example.filmhub.config.JWTGenerator;
import com.example.filmhub.model.Role;
import com.example.filmhub.model.User;
import com.example.filmhub.repository.RoleRepository;
import com.example.filmhub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController{
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JWTGenerator jwtGenerator;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository,
                          RoleRepository roleRepository, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody LoginDto registerDto) {
        if(userRepository.existsByUsername(registerDto.getUsername())){
            return new ResponseEntity<>("Username is already taken", HttpStatus.BAD_REQUEST);
        }

        User userEntity = new User();
        userEntity.setUsername(registerDto.getUsername());
        userEntity.setPassword(passwordEncoder.encode(registerDto.getPassword()));

//        Optional<Role> roleOptional = roleRepository.findByName("USER");
//
//        if (roleOptional.isPresent()) {
//            Role role = roleOptional.get();
//            userEntity.setRoles(Collections.singletonList(role));
//        }
        userRepository.save(userEntity);

        return new ResponseEntity<>("Success, user registered!", HttpStatus.OK);
    }
}
