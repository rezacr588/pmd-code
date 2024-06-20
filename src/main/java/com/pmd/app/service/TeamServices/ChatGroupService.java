package com.pmd.app.service.TeamServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmd.app.model.TeamModels.ChatGroup;
import com.pmd.app.model.User;
import com.pmd.app.repository.TeamRepositories.ChatGroupRepository;

@Service
public class ChatGroupService {

  @Autowired
  private ChatGroupRepository chatGroupRepository;

  public ChatGroup saveChatGroup(ChatGroup chatGroup) {
    return chatGroupRepository.save(chatGroup);
  }

  public Optional<ChatGroup> getChatGroup(Long id) {
    return chatGroupRepository.findById(id);
  }

  public List<ChatGroup> getAllChatGroups() {
    return chatGroupRepository.findAll();
  }

  public void deleteChatGroup(Long id) {
    chatGroupRepository.deleteById(id);
  }

  public ChatGroup addUserToGroup(ChatGroup chatGroup, User user) {
    chatGroup.getUsers().add(user);
    return chatGroupRepository.save(chatGroup);
  }

  public ChatGroup removeUserFromGroup(ChatGroup chatGroup, User user) {
    chatGroup.getUsers().remove(user);
    return chatGroupRepository.save(chatGroup);
  }

  public void closeChatGroup(Long chatGroupId) {
    ChatGroup chatGroup = chatGroupRepository.findById(chatGroupId)
        .orElseThrow(() -> new RuntimeException("Chat group not found"));
    chatGroup.setStatus(true); // Assuming true means the chat group is closed
    chatGroupRepository.save(chatGroup);
  }

}