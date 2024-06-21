package com.pmd.app.repository.TeamRepositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmd.app.model.TeamModels.TeamMessage;
import com.pmd.app.model.User;

@Repository
public interface TeamMessageRepository extends JpaRepository<TeamMessage, Long> {
  List<TeamMessage> findBySenderAndReceiver(User sender, User receiver);
}