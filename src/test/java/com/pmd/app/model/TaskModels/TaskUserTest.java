package com.pmd.app.model.TaskModels;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.pmd.app.model.User;

public class TaskUserTest {

  @Test
  public void testTaskUser() {
    Task task = new Task();
    User user = new User();
    TaskUser taskUser = new TaskUser(task, user);

    assertEquals(task, taskUser.getTask());
    assertEquals(user, taskUser.getUser());

    Task newTask = new Task();
    User newUser = new User();
    taskUser.setTask(newTask);
    taskUser.setUser(newUser);

    assertEquals(newTask, taskUser.getTask());
    assertEquals(newUser, taskUser.getUser());
  }
}