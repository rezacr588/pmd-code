package com.pmd.app.repository;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.pmd.app.model.User;

@DataJpaTest
public class UserRepositoryTest {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private UserRepository userRepository;

  @Test
  public void whenFindByUsername_thenReturnUser() {
    // given
    User user = new User();
    user.setUsername("testUser");
    entityManager.persist(user);
    entityManager.flush();

    // when
    User found = userRepository.findByUsername(user.getUsername());

    // then
    assertThat(found.getUsername()).isEqualTo(user.getUsername());
  }
}