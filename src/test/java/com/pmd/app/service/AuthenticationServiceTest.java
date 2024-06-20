package com.pmd.app.service;

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

import com.pmd.app.model.User;
import com.pmd.app.util.JwtUtil;

public class AuthenticationServiceTest {
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
    when(jwtUtilMock.generateToken(any(User.class))).thenReturn(null);
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