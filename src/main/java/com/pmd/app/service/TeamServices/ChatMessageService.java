package com.pmd.app.service.TeamServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmd.app.model.TeamModels.ChatMessage;
import com.pmd.app.repository.TeamRepositories.ChatMessageRepository;

@Service
public class ChatMessageService {

  @Autowired
  private ChatMessageRepository chatMessageRepository;

  public List<ChatMessage> getAllChatMessages() {
    return chatMessageRepository.findAll();
  }

  public Optional<ChatMessage> getChatMessageById(Long id) {
    return chatMessageRepository.findById(id);
  }

  public ChatMessage saveChatMessage(ChatMessage chatMessage) {
    return chatMessageRepository.save(chatMessage);
  }

  public void deleteChatMessage(Long id) {
    chatMessageRepository.deleteById(id);
  }

  public List<ChatMessage> getChatHistory(Long groupId) {
    // Fetch the chat history from the database
    return chatMessageRepository.findByChatGroup_Id(groupId);
  }
}