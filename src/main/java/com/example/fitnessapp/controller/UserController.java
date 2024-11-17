package com.example.fitnessapp.controller;

import com.example.fitnessapp.dto.UserDTO;
import com.example.fitnessapp.dto.UserMapper;
import com.example.fitnessapp.dto.UserRegistrationDTO;
import com.example.fitnessapp.model.User;
import com.example.fitnessapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserDTO registerUser(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        User user = userService.registerUser(UserMapper.fromDTO(userRegistrationDTO));
        return UserMapper.toDTO(user);
    }

    @GetMapping
    public List<User> getUsers() {
        // Use the injected service instance, not a static call
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return (User) userService.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

    }
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.deleteUserById(id);
}
}
