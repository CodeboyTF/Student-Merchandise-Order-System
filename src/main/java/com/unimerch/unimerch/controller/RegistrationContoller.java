package com.unimerch.unimerch.controller;

import com.unimerch.unimerch.entity.User;
import com.unimerch.unimerch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationContoller {

@Autowired
private UserRepository userRepository;

@Autowired
private PasswordEncoder passwordEncoder;

@PostMapping("/register/user")
public User createUser(
        @RequestBody User user){
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.save(user);}
}
















