package com.pmd.app.controller.TeamControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import com.pmd.app.model.TeamModels.TeamMessage;
import com.pmd.app.model.User;
import com.pmd.app.service.TeamServices.TeamMessageService;

@Controller
public class TeamMessageController {
  @Autowired
  private TeamMessageService teamMessageService;

  @Autowired
  private SimpMessagingTemplate simpMessagingTemplate;

  @MessageMapping("/sendMessage")
  public void sendMessage(User sender, User receiver, String message) {
    TeamMessage teamMessage = teamMessageService.sendMessage(sender, receiver, message);
    simpMessagingTemplate.convertAndSendToUser(receiver.getUsername(), "/queue/messages", teamMessage);
  }

  @SubscribeMapping("/user/{username1}/{username2}/queue/messages")
  public List<TeamMessage> retrieveMessages(User user1, User user2) {
    return teamMessageService.getMessagesBetweenUsers(user1, user2);
  }
}