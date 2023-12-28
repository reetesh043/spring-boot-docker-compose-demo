package com.example.spring.docker.controller;

import com.example.spring.docker.domain.TestUser;
import com.example.spring.docker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public TestUser createUser(@RequestBody TestUser user) {
        return userService.createUser(user);
    }


    @GetMapping
    public List<TestUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public TestUser getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }


    @PutMapping("/{id}")
    public TestUser updateUser(@PathVariable Long id, @RequestBody TestUser updatedUser) {
        return userService.updateUserDetails(id, updatedUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
