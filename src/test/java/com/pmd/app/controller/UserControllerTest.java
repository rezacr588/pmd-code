package com.pmd.app.controller;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.pmd.app.model.User;
import com.pmd.app.service.UserService;

public class UserControllerTest {

  @InjectMocks
  UserController userController;

  @Mock
  UserService userService;

  @BeforeEach
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testUpdateUser() {
    User user = new User();
    user.setUsername("test");
    user.setEmail("test@test.com");
    user.setPassword("password");

    when(userService.findUserByUsername("test")).thenReturn(Optional.of(user));

    ResponseEntity<User> response = userController.updateUser("test", user);

    assertEquals(200, response.getStatusCodeValue());
    verify(userService, times(1)).updateUser(user);
  }

  @Test
  public void testDeleteUser() {
    User user = new User();
    user.setUsername("test");
    user.setEmail("test@test.com");
    user.setPassword("password");

    when(userService.findUserByUsername("test")).thenReturn(Optional.of(user));

    ResponseEntity<?> response = userController.deleteUser("test");

    assertEquals(200, response.getStatusCodeValue());
    verify(userService, times(1)).deleteUser(user.getId());
  }

  @Test
  public void testRegisterUser() {
    User user = new User();
    user.setUsername("test");
    user.setEmail("test@test.com");
    user.setPassword("password");
    when(userService.registerNewUserAccount(user)).thenReturn(user);
    ResponseEntity<User> response = userController.registerUser(user);
    assertEquals(200, response.getStatusCodeValue());
    assertEquals(user, response.getBody());
  }

  @Test
  public void testGetUserByUsername() {
    User user = new User();
    user.setUsername("test");
    user.setEmail("test@test.com");
    user.setPassword("password");
    when(userService.findUserByUsername("test")).thenReturn(Optional.of(user));
    ResponseEntity<User> response = userController.getUserByUsername("test");
    assertEquals(200, response.getStatusCodeValue());
    assertEquals(user, response.getBody());
    verify(userService, times(1)).findUserByUsername("test");
  }

  @Test
  public void testGetUserByUsernameNotFound() {
    when(userService.findUserByUsername("test")).thenReturn(Optional.empty());
    try {
      userController.getUserByUsername("test");
    } catch (RuntimeException e) {
      assertEquals("User not found with username: test", e.getMessage());
    }
  }

}