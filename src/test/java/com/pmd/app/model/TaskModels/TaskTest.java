package com.pmd.app.model.TaskModels;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class TaskTest {

  @Test
  public void testAddAndRemoveTaskUser() {
    Task task = new Task();
    TaskUser taskUser = new TaskUser();
    // Test addTaskUser
    task.addTaskUser(taskUser);
    assertTrue(task.getTaskUsers().contains(taskUser));

    // Test removeTaskUser
    task.removeTaskUser(taskUser);
    assertFalse(task.getTaskUsers().contains(taskUser));
  }

  @Test
  public void testClearTaskUsers() {
    Task task = new Task();
    TaskUser taskUser1 = new TaskUser();
    TaskUser taskUser2 = new TaskUser();
    task.addTaskUser(taskUser1);
    task.addTaskUser(taskUser2);

    task.clearTaskUsers();
    assertTrue(task.getTaskUsers().isEmpty());
  }
}