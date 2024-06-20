package com.pmd.app.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pmd.app.model.User;
import com.pmd.app.repository.UserRepository;

@SpringBootTest
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

  @Test
  void loadUserByUsername_WhenUserDoesNotExist_ShouldThrowUsernameNotFoundException() {
    // Arrange
    String username = "testUser";

    when(userRepository.findByUsername(username)).thenReturn(null);

    // Act and Assert
    assertThrows(UsernameNotFoundException.class, () -> userDetailsService.loadUserByUsername(username));
  }

}
