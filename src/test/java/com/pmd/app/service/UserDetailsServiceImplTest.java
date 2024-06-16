package com.pmd.app.service;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pmd.app.model.User;
import com.pmd.app.repository.UserRepository;

public class UserDetailsServiceImplTest {

  @InjectMocks
  private UserDetailsServiceImpl userDetailsService;

  @Mock
  private UserRepository userRepository;

  @BeforeEach
  public void init() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void loadUserByUsernameTest() {
    User user = new User();
    user.setUsername("testUser");

    when(userRepository.findByUsername("testUser")).thenReturn(Optional.of(user));

    assertEquals(userDetailsService.loadUserByUsername("testUser").getUsername(), "testUser");
  }

  @Test
  public void loadUserByUsernameNotFoundTest() {
    when(userRepository.findByUsername("testUser")).thenReturn(Optional.empty());

    assertThrows(UsernameNotFoundException.class, () -> userDetailsService.loadUserByUsername("testUser"));
  }
}