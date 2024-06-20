package com.pmd.app.controller.TeamControllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

import com.pmd.app.model.TeamModels.ChatGroup;
import com.pmd.app.model.TeamModels.ChatMessage;
import com.pmd.app.model.User;
import com.pmd.app.service.TeamServices.ChatGroupService;
import com.pmd.app.service.TeamServices.ChatMessageService;

@ExtendWith(MockitoExtension.class)
public class ChatControllerTest {

  @Mock
  private ChatMessageService chatMessageService;

  @Mock
  private ChatGroupService chatGroupService;

  @Mock
  private SimpMessageHeaderAccessor headerAccessor;

  @InjectMocks
  private ChatController chatController;

  private ChatMessage testMessage;
  private ChatGroup testGroup;
  private User testUser;

  @BeforeEach
  void setUp() {
    testUser = new User(1L, "testuser", "password", "test@example.com", null);
    testMessage = new ChatMessage();
    testMessage.setUser(testUser);
    testMessage.setContent("Test message");

    testGroup = new ChatGroup();
    testGroup.setId(1L);
  }

  @Test
  void testSendMessage() {
    when(chatMessageService.saveChatMessage(any(ChatMessage.class))).thenReturn(testMessage);

    ChatMessage result = chatController.sendMessage(1L, testMessage);

    assertNotNull(result);
    assertEquals(testMessage, result);
    verify(chatMessageService).saveChatMessage(testMessage);
  }

  @Test
  void testAddUser() {
    when(headerAccessor.getSessionAttributes()).thenReturn(new HashMap<>());

    ChatMessage result = chatController.addUser(1L, testMessage, headerAccessor);

    assertNotNull(result);
    assertEquals(testMessage, result);
    verify(headerAccessor).getSessionAttributes();
  }

  @Test
  void testGetChatHistory() {
    List<ChatMessage> chatHistory = Arrays.asList(testMessage);
    when(chatMessageService.getChatHistory(1L)).thenReturn(chatHistory);

    List<ChatMessage> result = chatController.getChatHistory(1L);

    assertNotNull(result);
    assertEquals(chatHistory, result);
    verify(chatMessageService).getChatHistory(1L);
  }

  @Test
  void testCreateGroup() {
    when(chatGroupService.saveChatGroup(any(ChatGroup.class))).thenReturn(testGroup);

    ChatGroup result = chatController.createGroup(testGroup);

    assertNotNull(result);
    assertEquals(testGroup, result);
    verify(chatGroupService).saveChatGroup(testGroup);
  }

  @Test
  void testAddUserToGroup() {
    when(chatGroupService.addUserToGroup(any(ChatGroup.class), any(User.class))).thenReturn(testGroup);

    ChatGroup result = chatController.addUserToGroup(testGroup, testUser);

    assertNotNull(result);
    assertEquals(testGroup, result);
    verify(chatGroupService).addUserToGroup(testGroup, testUser);
  }

  @Test
  void testRemoveUserFromGroup() {
    when(chatGroupService.removeUserFromGroup(any(ChatGroup.class), any(User.class))).thenReturn(testGroup);

    ChatGroup result = chatController.removeUserFromGroup(testGroup, testUser);

    assertNotNull(result);
    assertEquals(testGroup, result);
    verify(chatGroupService).removeUserFromGroup(testGroup, testUser);
  }

  @Test
  void testCloseChatGroup() {
    doNothing().when(chatGroupService).closeChatGroup(anyLong());

    chatController.closeChatGroup(1L);

    verify(chatGroupService).closeChatGroup(1L);
  }
}