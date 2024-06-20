package com.pmd.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        User user = userService.findUserByUsername(username);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{username}")
    public ResponseEntity<User> updateUser(@PathVariable String username, @RequestBody User user) {
        User existingUser = userService.findUserByUsername(username);
        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        userService.updateUser(existingUser);
        return ResponseEntity.ok(existingUser);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username) {
        User existingUser = userService.findUserByUsername(username);
        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteUser(existingUser.getId());
        return ResponseEntity.ok().build();
    }
}