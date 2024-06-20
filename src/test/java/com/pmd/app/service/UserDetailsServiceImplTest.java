package com.pmd.app.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

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

    when(userRepository.findByUsername(user.getUsername())).thenReturn(user);

  }

}