package com.example.fitnessapp.controller;

import com.example.fitnessapp.dto.UserDTO;
import com.example.fitnessapp.dto.UserMapper;
import com.example.fitnessapp.dto.UserRegistrationDTO;
import com.example.fitnessapp.model.User;
import com.example.fitnessapp.repository.UserRepository;
import com.example.fitnessapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserDTO registerUser(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        User user = userService.registerUser(UserMapper.fromDTO(userRegistrationDTO));
        return UserMapper.toDTO(user);
    }
    @GetMapping
    public List<User> getAllUsers() {
        return UserService.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return (User) UserService.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
