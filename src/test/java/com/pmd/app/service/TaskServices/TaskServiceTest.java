package com.pmd.app.service.TaskServices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pmd.app.model.TaskModels.Task;
import com.pmd.app.model.TeamModels.ChatGroup;
import com.pmd.app.repository.TasksRepositories.TaskRepository;
import com.pmd.app.repository.TeamRepositories.ChatGroupRepository;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

  @Mock
  private TaskRepository taskRepository;

  @Mock
  private ChatGroupRepository chatGroupRepository;

  @InjectMocks
  private TaskService taskService;

  private Task task;
  private ChatGroup chatGroup;

  @BeforeEach
  void setUp() {
    task = new Task();
    task.setId(1L);
    task.setName("Test Task");
    task.setStatus(false);

    chatGroup = new ChatGroup();
    chatGroup.setId(1L);
    chatGroup.setStatus(false);
  }

  @Test
  void testCreateTask() {
    when(taskRepository.save(any(Task.class))).thenReturn(task);

    Task createdTask = taskService.createTask(task);

    assertNotNull(createdTask);
    assertEquals(task.getId(), createdTask.getId());
    verify(taskRepository).save(task);
  }

  @Test
  void testGetTask() {
    when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

    Optional<Task> foundTask = taskService.getTask(1L);

    assertTrue(foundTask.isPresent());
    assertEquals(task.getId(), foundTask.get().getId());
  }

  @Test
  void testGetAllTasks() {
    List<Task> tasks = Arrays.asList(task);
    when(taskRepository.findAll()).thenReturn(tasks);

    List<Task> foundTasks = taskService.getAllTasks();

    assertFalse(foundTasks.isEmpty());
    assertEquals(1, foundTasks.size());
  }

  @Test
  void testUpdateTask() {
    when(taskRepository.save(any(Task.class))).thenReturn(task);

    Task updatedTask = taskService.updateTask(task);

    assertNotNull(updatedTask);
    assertEquals(task.getId(), updatedTask.getId());
    verify(taskRepository).save(task);
  }

  @Test
  void testDeleteTask() {
    doNothing().when(taskRepository).deleteById(1L);

    taskService.deleteTask(1L);

    verify(taskRepository).deleteById(1L);
  }

  @Test
  void testCloseTask_NotAllTasksClosed() {
    // Initialize the task and chat group
    Task task = new Task();
    task.setId(1L);
    task.setStatus(false);
    task.setChatGroups(new ArrayList<>());

    ChatGroup chatGroup = new ChatGroup();
    chatGroup.setId(1L);
    chatGroup.setStatus(true);
    chatGroup.setTasks(new ArrayList<>());

    Task openTask = new Task();
    openTask.setId(2L);
    openTask.setStatus(true);

    // Add the chat group to the task
    task.getChatGroups().add(chatGroup);

    // Add both tasks to the chat group
    chatGroup.getTasks().add(task);
    chatGroup.getTasks().add(openTask);

    when(taskRepository.findById(1L)).thenReturn(Optional.of(task));
    when(taskRepository.save(any(Task.class))).thenReturn(task);

    Task closedTask = taskService.closeTask(1L);

    assertFalse(closedTask.getStatus());
    assertTrue(chatGroup.getStatus());
    verify(taskRepository).save(task);
    verify(chatGroupRepository, never()).save(any(ChatGroup.class));
  }

  @Test
  void testCloseTask_TaskNotFound() {
    when(taskRepository.findById(1L)).thenReturn(Optional.empty());

    assertThrows(RuntimeException.class, () -> taskService.closeTask(1L));
  }
}