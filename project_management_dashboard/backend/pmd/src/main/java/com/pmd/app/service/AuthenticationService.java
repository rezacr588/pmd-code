package com.pmd.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.pmd.app.model.User;
import com.pmd.app.service.UserService;
import com.pmd.app.util.JwtUtil;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserService userService;

    @Autowired
    public AuthenticationService(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    public String login(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = userService.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        return jwtUtil.generateToken(user);
    }

    public void logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
    }
}