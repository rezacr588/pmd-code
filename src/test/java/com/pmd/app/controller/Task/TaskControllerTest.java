package com.pmd.app.controller.Task;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.pmd.app.model.TaskModels.Task;
import com.pmd.app.service.TaskServices.TaskService;

public class TaskControllerTest {

  @InjectMocks
  TaskController taskController;

  @Mock
  TaskService taskService;

  @BeforeEach
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testCreateTask() {
    Task task = new Task();
    when(taskService.createTask(task)).thenReturn(task);
    Task result = taskController.createTask(task);
    assertEquals(task, result);
  }

  @Test
  public void testGetTask() {
    Task task = new Task();
    when(taskService.getTask(1L)).thenReturn(Optional.of(task));
    Task result = taskController.getTask(1L);
    assertEquals(task, result);
  }

  @Test
  public void testGetAllTasks() {
    Task task = new Task();
    when(taskService.getAllTasks()).thenReturn(Arrays.asList(task));
    List<Task> result = taskController.getAllTasks();
    assertEquals(1, result.size());
    assertEquals(task, result.get(0));
  }

  @Test
  public void testUpdateTask() {
    Task task = new Task();
    when(taskService.updateTask(task)).thenReturn(task);
    Task result = taskController.updateTask(task);
    assertEquals(task, result);
  }

  @Test
  public void testDeleteTask() {
    doNothing().when(taskService).deleteTask(1L);
    taskController.deleteTask(1L);
    verify(taskService, times(1)).deleteTask(1L);
  }
}