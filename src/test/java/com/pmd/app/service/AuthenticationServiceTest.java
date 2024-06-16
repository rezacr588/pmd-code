package com.pmd.app.service;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pmd.app.model.User;
import com.pmd.app.util.JwtUtil;

public class AuthenticationServiceTest {

  @Test
  public void login_ShouldReturnJwt() {
    // Arrange
    String expectedJwt = "dummyJwtToken";
    String username = "testUser";
    String password = "testPassword";

    AuthenticationManager authenticationManagerMock = mock(AuthenticationManager.class);
    JwtUtil jwtUtilMock = mock(JwtUtil.class);
    UserService userServiceMock = mock(UserService.class);

    AuthenticationService authenticationService = new AuthenticationService(authenticationManagerMock, jwtUtilMock,
        userServiceMock);

    when(authenticationManagerMock.authenticate(any(UsernamePasswordAuthenticationToken.class)))
        .thenReturn(mock(Authentication.class));
    when(userServiceMock.findUserByUsername(username)).thenReturn(Optional.of(new User()));
    when(jwtUtilMock.generateToken(any(User.class))).thenReturn(expectedJwt);

    // Act
    String actualJwt = authenticationService.login(username, password);

    // Assert
    assertEquals(expectedJwt, actualJwt);
  }

  @Test
  public void login_ShouldThrowUsernameNotFoundException() {
    // Arrange
    String username = "testUser";
    String password = "testPassword";

    AuthenticationManager authenticationManagerMock = mock(AuthenticationManager.class);
    JwtUtil jwtUtilMock = mock(JwtUtil.class);
    UserService userServiceMock = mock(UserService.class);

    AuthenticationService authenticationService = new AuthenticationService(authenticationManagerMock, jwtUtilMock,
        userServiceMock);

    when(authenticationManagerMock.authenticate(any(UsernamePasswordAuthenticationToken.class)))
        .thenReturn(mock(Authentication.class));
    when(userServiceMock.findUserByUsername(username)).thenReturn(Optional.empty());

    // Act & Assert
    assertThrows(UsernameNotFoundException.class, () -> authenticationService.login(username, password));
  }

  @Test
  public void logout_ShouldClearAuthentication() {
    // Arrange
    AuthenticationManager authenticationManagerMock = mock(AuthenticationManager.class);
    JwtUtil jwtUtilMock = mock(JwtUtil.class);
    UserService userServiceMock = mock(UserService.class);

    AuthenticationService authenticationService = new AuthenticationService(authenticationManagerMock, jwtUtilMock,
        userServiceMock);

    SecurityContext securityContextMock = mock(SecurityContext.class);
    SecurityContextHolder.setContext(securityContextMock);

    // Act
    authenticationService.logout();

    // Assert
    verify(securityContextMock).setAuthentication(null);
  }
}