package com.pmd.app.service;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

import com.pmd.app.model.Role;
import com.pmd.app.model.User;

public class UserPrincipalTest {

  private UserPrincipal userPrincipal;
  private User user;

  @BeforeEach
  public void setup() {
    user = new User();
    user.setUsername("username");
    user.setPassword("password");
    user.setRole(Role.USER);
    userPrincipal = new UserPrincipal(user);
  }

  @Test
  public void getAuthorities_ShouldReturnUserAuthorities() {
    Collection<? extends GrantedAuthority> authorities = userPrincipal.getAuthorities();

    assertEquals(1, authorities.size());
    assertEquals("USER", authorities.iterator().next().getAuthority());
  }

  @Test
  public void getPassword_ShouldReturnUserPassword() {
    assertEquals("password", userPrincipal.getPassword());
  }

  @Test
  public void getUsername_ShouldReturnUserUsername() {
    assertEquals("username", userPrincipal.getUsername());
  }

  @Test
  public void isAccountNonExpired_ShouldReturnTrue() {
    assertEquals(true, userPrincipal.isAccountNonExpired());
  }

  @Test
  public void isAccountNonLocked_ShouldReturnTrue() {
    assertEquals(true, userPrincipal.isAccountNonLocked());
  }

  @Test
  public void isCredentialsNonExpired_ShouldReturnTrue() {
    assertEquals(true, userPrincipal.isCredentialsNonExpired());
  }

  @Test
  public void isEnabled_ShouldReturnTrue() {
    assertEquals(true, userPrincipal.isEnabled());
  }
}