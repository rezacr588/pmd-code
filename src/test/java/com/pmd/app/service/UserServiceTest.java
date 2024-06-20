package com.pmd.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pmd.app.model.User;
import com.pmd.app.repository.UserRepository;

public class UserServiceTest {

  @Mock
  private UserRepository userRepository;

  @Mock
  private PasswordEncoder passwordEncoder;

  private UserService userService;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
    userService = new UserService(userRepository, passwordEncoder);
  }

  @Test
  public void registerNewUserAccount_ShouldSaveUser() {
    User user = new User();
    user.setPassword("password");

    when(passwordEncoder.encode(user.getPassword())).thenReturn("encodedPassword");
    when(userRepository.save(user)).thenReturn(user);

    User savedUser = userService.registerNewUserAccount(user);

    assertEquals("encodedPassword", savedUser.getPassword());
    verify(userRepository, times(1)).save(user);
  }

  @Test
  public void findUserByUsername_ShouldReturnUser() {
    User user = new User();
    user.setUsername("username");

    when(userRepository.findByUsername(user.getUsername())).thenReturn(user);

    User foundUser = userService.findUserByUsername(user.getUsername());

    assertEquals(user.getUsername(), foundUser.getUsername());
    verify(userRepository, times(1)).findByUsername(user.getUsername());
  }
}