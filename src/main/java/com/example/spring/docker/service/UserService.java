package com.example.spring.docker.service;


import com.example.spring.docker.domain.TestUser;
import com.example.spring.docker.exception.UserException;
import com.example.spring.docker.exception.UserNotFoundException;
import com.example.spring.docker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public TestUser createUser(TestUser user) {
        // Check if the username is already taken
        if (userRepository.findByUserName(user.getUserName()) != null) {
            throw new UserException("Username is already taken");
        }
        // Save the user to the database
        return userRepository.save(user);
    }

    public TestUser updateUserDetails(Long userId, TestUser updatedUser) {
        Optional<TestUser> existingUser = userRepository.findById(userId);

        if (existingUser.isPresent()) {
            TestUser user = existingUser.get();

            // Update user details as needed (e.g., name, email, etc.)
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setEmail(updatedUser.getEmail());
            user.setUserName(updatedUser.getUserName());

            // Save the updated user to the database
            return userRepository.save(user);
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    public TestUser getUserById(Long userId) {
        Optional<TestUser> user = userRepository.findById(userId);
        return user.orElse(null);
    }

    public List<TestUser> getAllUsers() {
        return userRepository.findAll();

    }

    public void deleteUser(Long userId) {
        Optional<TestUser> user = userRepository.findById(userId);
        if (user.isPresent()) {
            userRepository.deleteById(userId);
        } else {
            throw new UserNotFoundException("User not found");
        }
    }
}
