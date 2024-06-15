package com.pmd.app.util;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.pmd.app.model.User;

@SpringBootTest
public class JwtUtilTest {

  @InjectMocks
  private JwtUtil jwtUtil;

  @Mock
  private User user;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    ReflectionTestUtils.setField(jwtUtil, "secretKey", "secret");
    ReflectionTestUtils.setField(jwtUtil, "expirationInSeconds", 3600L);
  }

  @Test
  public void testGenerateToken() {
    when(user.getUsername()).thenReturn("testUser");
    String token = jwtUtil.generateToken(user);
    assertNotNull(token);
  }

  @Test
  public void testValidateToken() {
    when(user.getUsername()).thenReturn("testUser");
    String token = jwtUtil.generateToken(user);
    assertTrue(jwtUtil.validateToken(token, user));
  }

  @Test
  public void testExtractUsername() {
    when(user.getUsername()).thenReturn("testUser");
    String token = jwtUtil.generateToken(user);
    assertEquals("testUser", jwtUtil.extractUsername(token));
  }

  @Test
  public void testExtractExpiration() {
    when(user.getUsername()).thenReturn("testUser");
    String token = jwtUtil.generateToken(user);
    Date expiration = jwtUtil.extractExpiration(token);
    assertTrue(expiration.after(new Date()));
  }
}