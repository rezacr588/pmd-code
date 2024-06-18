package com.pmd.app.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.pmd.app.model.User;
import com.pmd.app.service.AuthenticationService;
import com.pmd.app.service.UserService;

public class AuthenticationControllerTest {

  @InjectMocks
  AuthenticationController authenticationController;

  @Mock
  AuthenticationService authenticationService;

  @Mock
  UserService userService;

  @BeforeEach
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testAuthenticationControllerConstructor() {
    assertNotNull(authenticationController);
  }

  @Test
  public void testLogout() {
    assertNotNull(authenticationController.logout());
  }

  @Test
  public void testLogin() {
    User user = new User();
    // Set up user object with necessary data for login

    ResponseEntity<String> response = authenticationController.login(user);

    assertNotNull(response);
    // Add assertions to verify the expected behavior of the login method
  }
}