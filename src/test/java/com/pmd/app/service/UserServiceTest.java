package com.pmd.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
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

  private User testUser;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
    testUser = new User("testuser", "password", "test@example.com", null);

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

  @Test
  void testRegisterNewUserAccount() {
    when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
    when(userRepository.save(any(User.class))).thenReturn(testUser);

    User savedUser = userService.registerNewUserAccount(testUser);

    assertNotNull(savedUser);
    assertEquals("testuser", savedUser.getUsername());
    verify(passwordEncoder).encode("password");
    verify(userRepository).save(testUser);
  }

  @Test
  void testFindUserByUsername() {
    when(userRepository.findByUsername("testuser")).thenReturn(testUser);

    User foundUser = userService.findUserByUsername("testuser");

    assertNotNull(foundUser);
    assertEquals("testuser", foundUser.getUsername());
    verify(userRepository).findByUsername("testuser");
  }

  @Test
  void testUpdateUser() {
    when(userRepository.save(any(User.class))).thenReturn(testUser);

    User updatedUser = userService.updateUser(testUser);

    assertNotNull(updatedUser);
    assertEquals("testuser", updatedUser.getUsername());
    verify(userRepository).save(testUser);
  }

  @Test
  void testDeleteUser() {
    doNothing().when(userRepository).deleteById(anyLong());

    userService.deleteUser(1L);

    verify(userRepository).deleteById(1L);
  }
}