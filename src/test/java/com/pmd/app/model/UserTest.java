package com.pmd.app.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class UserTest {

  @Test
  void testGettersAndSetters() {
    User user = new User();

    user.setId(1L);
    user.setUsername("testUser");
    user.setPassword("testPassword");
    user.setEmail("test@example.com");
    user.setRole(User.Role.ADMIN);

    assertEquals(1L, user.getId());
    assertEquals("testUser", user.getUsername());
    assertEquals("testPassword", user.getPassword());
    assertEquals("test@example.com", user.getEmail());
    assertEquals(User.Role.ADMIN, user.getRole());
  }

  @Test
  void testToString() {
    User user = new User(1L, "testUser", "testPassword", "test@example.com", User.Role.ADMIN);
    String expected = "User{id=1, username='testUser', email='test@example.com', role=ADMIN, createdAt=null, updatedAt=null}";
    assertEquals(expected, user.toString());
  }
}