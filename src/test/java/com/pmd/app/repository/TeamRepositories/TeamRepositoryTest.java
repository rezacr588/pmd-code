package com.pmd.app.repository.TeamRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

public class TeamRepositoryTest {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private TeamRepository teamRepository;
}