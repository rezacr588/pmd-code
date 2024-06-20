package com.pmd.app.controller.TeamControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.DestinationVariable;

import com.pmd.app.model.TeamModels.ChatGroup;
import com.pmd.app.model.TeamModels.ChatMessage;
import com.pmd.app.service.TeamServices.ChatGroupService;
import com.pmd.app.service.TeamServices.ChatMessageService;
import com.pmd.app.model.User;

@Controller
public class ChatController {

  @Autowired
  private ChatMessageService chatMessageService;

  @Autowired
  private ChatGroupService chatGroupService;

  @MessageMapping("/chat.sendMessage/{groupId}")
  @SendTo("/topic/group/{groupId}")
  public ChatMessage sendMessage(@DestinationVariable Long groupId, @Payload ChatMessage chatMessage) {
    // Save the chat message to the database
    ChatMessage savedMessage = chatMessageService.saveChatMessage(chatMessage);
    // Return the saved message to broadcast it to all clients in the group
    return savedMessage;
  }

  @MessageMapping("/chat.addUser/{groupId}")
  @SendTo("/topic/group/{groupId}")
  public ChatMessage addUser(@DestinationVariable Long groupId, @Payload ChatMessage chatMessage,
      SimpMessageHeaderAccessor headerAccessor) {
    // Add username in web socket session
    headerAccessor.getSessionAttributes().put("username", chatMessage.getUser());
    // Return the chat message to send it to the client
    return chatMessage;
  }

  @MessageMapping("/chat.history/{groupId}")
  @SendTo("/topic/history/{groupId}")
  public List<ChatMessage> getChatHistory(@DestinationVariable Long groupId) {
    // Fetch the chat history from the database
    List<ChatMessage> chatHistory = chatMessageService.getChatHistory(groupId);
    // Return the chat history to send it to the client
    return chatHistory;
  }

  @MessageMapping("/chat.createGroup")
  public ChatGroup createGroup(@Payload ChatGroup chatGroup) {
    return chatGroupService.saveChatGroup(chatGroup);
  }

  @MessageMapping("/chat.addUserToGroup")
  public ChatGroup addUserToGroup(@Payload ChatGroup chatGroup, @Payload User chatUser) {
    return chatGroupService.addUserToGroup(chatGroup, chatUser);
  }

  @MessageMapping("/chat.removeUserFromGroup")
  public ChatGroup removeUserFromGroup(@Payload ChatGroup chatGroup, @Payload User chatUser) {
    return chatGroupService.removeUserFromGroup(chatGroup, chatUser);
  }

  @MessageMapping("/chat.closeGroup/{groupId}")
  public void closeChatGroup(@DestinationVariable Long groupId) {
    chatGroupService.closeChatGroup(groupId);
  }
}