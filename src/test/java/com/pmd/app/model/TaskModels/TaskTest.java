package com.pmd.app.model.TaskModels;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pmd.app.model.TeamModels.ChatGroup;

public class TaskTest {

  private Task task;
  private Column column;
  private TaskUser taskUser;
  private ChatGroup chatGroup;

  @BeforeEach
  void setUp() {
    task = new Task();
    column = new Column();
    taskUser = new TaskUser();
    chatGroup = new ChatGroup();
  }

  @Test
  void testTaskCreation() {
    assertNotNull(task);
    assertTrue(task.getTaskUsers().isEmpty());
    assertNull(task.getChatGroups());
  }

  @Test
  void testSetAndGetId() {
    task.setId(1L);
    assertEquals(1L, task.getId());
  }

  @Test
  void testSetAndGetName() {
    task.setName("Test Task");
    assertEquals("Test Task", task.getName());
  }

  @Test
  void testSetAndGetOrder() {
    task.setOrder(1);
    assertEquals(1, task.getOrder());
  }

  @Test
  void testSetAndGetStatus() {
    task.setStatus(true);
    assertTrue(task.getStatus());
  }

  @Test
  void testSetAndGetColumn() {
    task.setColumn(column);
    assertEquals(column, task.getColumn());
  }

  @Test
  void testAddTaskUser() {
    task.addTaskUser(taskUser);
    assertEquals(1, task.getTaskUsers().size());
    assertTrue(task.getTaskUsers().contains(taskUser));
  }

  @Test
  void testRemoveTaskUser() {
    task.addTaskUser(taskUser);
    task.removeTaskUser(taskUser);
    assertTrue(task.getTaskUsers().isEmpty());
  }

  @Test
  void testClearTaskUsers() {
    task.addTaskUser(taskUser);
    task.clearTaskUsers();
    assertTrue(task.getTaskUsers().isEmpty());
  }

  @Test
  void testSetTaskUsers() {
    List<TaskUser> taskUsers = new ArrayList<>();
    taskUsers.add(taskUser);
    task.setTaskUsers(taskUsers);
    assertEquals(1, task.getTaskUsers().size());
    assertTrue(task.getTaskUsers().contains(taskUser));
  }

  @Test
  void testSetAndGetChatGroups() {
    List<ChatGroup> chatGroups = new ArrayList<>();
    chatGroups.add(chatGroup);
    task.setChatGroups(chatGroups);
    assertEquals(chatGroups, task.getChatGroups());
  }

  @Test
  void testAddChatGroup() {
    task.setChatGroups(new ArrayList<>());
    task.addChatGroup(chatGroup);
    assertEquals(1, task.getChatGroups().size());
    assertTrue(task.getChatGroups().contains(chatGroup));
  }

  @Test
  void testRemoveChatGroup() {
    task.setChatGroups(new ArrayList<>());
    task.addChatGroup(chatGroup);
    task.removeChatGroup(chatGroup);
    assertTrue(task.getChatGroups().isEmpty());
  }

  @Test
  void testClearChatGroups() {
    task.setChatGroups(new ArrayList<>());
    task.addChatGroup(chatGroup);
    task.clearChatGroups();
    assertTrue(task.getChatGroups().isEmpty());
  }
}