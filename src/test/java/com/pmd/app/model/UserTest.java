package com.pmd.app.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.pmd.app.model.TeamModels.Team;

class UserTest {

  @Test
  void testGettersAndSetters() {
    User user = new User();

    user.setId(1L);
    user.setUsername("testUser");
    user.setPassword("testPassword");
    user.setEmail("test@example.com");
    user.setRole(Role.ADMIN);

    assertEquals(1L, user.getId());
    assertEquals("testUser", user.getUsername());
    assertEquals("testPassword", user.getPassword());
    assertEquals("test@example.com", user.getEmail());
    assertEquals(Role.ADMIN, user.getRole());
  }

  @Test
  public void getCreatedAt() {
    User u = new User("abc", "abc", "abc", new Role("abc"));
    LocalDateTime expected = null;
    LocalDateTime actual = u.getCreatedAt();

    assertEquals(expected, actual);
  }

  @Test
  public void getUpdatedAt() {
    User u = new User("abc", "abc", "abc", new Role("abc"));
    LocalDateTime expected = null;
    LocalDateTime actual = u.getUpdatedAt();

    assertEquals(expected, actual);
  }

  @Test
  public void getTeams() {
    User u = new User("abc", "abc", "abc", new Role("abc"));
    List<Team> expected = new ArrayList<>();
    List<Team> actual = u.getTeams();

    assertEquals(expected, actual);
  }

  @Test
  public void setTeams() {
    User u = new User("abc", "abc", "abc", new Role("abc"));
    List<Team> teams = new ArrayList<>();
    u.setTeams(teams);
  }

}
