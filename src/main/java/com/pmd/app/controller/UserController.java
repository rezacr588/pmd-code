package com.pmd.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pmd.app.model.User;
import com.pmd.app.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User newUser = userService.registerNewUserAccount(user);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.findUserByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{username}")
    public ResponseEntity<User> updateUser(@PathVariable String username, @RequestBody User user) {
        User existingUser = userService.findUserByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        userService.updateUser(existingUser);
        return ResponseEntity.ok(existingUser);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username) {
        User existingUser = userService.findUserByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
        userService.deleteUser(existingUser.getId());
        return ResponseEntity.ok().build();
    }
}