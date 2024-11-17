
package com.example.fitnessapp.service;

import com.example.fitnessapp.model.User;
import com.example.fitnessapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public static <T> Optional<T> findById(Long id) {
        return null;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByEmail(username);
    }

    public User updateUser(Long id, User updatedUser) {
        return updatedUser;


    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}



