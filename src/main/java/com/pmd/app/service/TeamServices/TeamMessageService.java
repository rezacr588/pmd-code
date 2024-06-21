package com.pmd.app.service.TeamServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmd.app.model.TeamModels.TeamMessage;
import com.pmd.app.model.User;
import com.pmd.app.repository.TeamRepositories.TeamMessageRepository;

@Service
public class TeamMessageService {
  @Autowired
  private TeamMessageRepository teamMessageRepository;

  public TeamMessage sendMessage(User sender, User receiver, String message) {
    TeamMessage teamMessage = new TeamMessage();
    teamMessage.setSender(sender);
    teamMessage.setReceiver(receiver);
    teamMessage.setMessage(message);
    return teamMessageRepository.save(teamMessage);
  }

  public List<TeamMessage> getMessagesBetweenUsers(User user1, User user2) {
    return teamMessageRepository.findBySenderAndReceiver(user1, user2);
  }
}