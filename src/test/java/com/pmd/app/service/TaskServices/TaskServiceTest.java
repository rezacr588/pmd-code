package com.pmd.app.service.TaskServices;

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
import com.pmd.app.repository.TasksRepositories.TaskRepository;

public class TaskServiceTest {

  @InjectMocks
  private TaskService taskService;

  @Mock
  private TaskRepository taskRepository;

  @BeforeEach
  public void init() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void createTaskTest() {
    Task task = new Task();
    when(taskRepository.save(task)).thenReturn(task);

    Task createdTask = taskService.createTask(task);

    assertEquals(createdTask, task);
    verify(taskRepository, times(1)).save(task);
  }

  @Test
  public void getTaskTest() {
    Task task = new Task();
    when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

    Optional<Task> returnedTask = taskService.getTask(1L);

    assertEquals(returnedTask.get(), task);
    verify(taskRepository, times(1)).findById(1L);
  }

  @Test
  public void getAllTasksTest() {
    Task task1 = new Task();
    Task task2 = new Task();
    List<Task> tasks = Arrays.asList(task1, task2);

    when(taskRepository.findAll()).thenReturn(tasks);

    List<Task> returnedTasks = taskService.getAllTasks();

    assertEquals(returnedTasks, tasks);
    verify(taskRepository, times(1)).findAll();
  }

  @Test
  public void updateTaskTest() {
    Task task = new Task();
    when(taskRepository.save(task)).thenReturn(task);

    Task updatedTask = taskService.updateTask(task);

    assertEquals(updatedTask, task);
    verify(taskRepository, times(1)).save(task);
  }

  @Test
  public void deleteTaskTest() {
    doNothing().when(taskRepository).deleteById(1L);

    taskService.deleteTask(1L);

    verify(taskRepository, times(1)).deleteById(1L);
  }
}