package com.pmd.app.model.TaskModels;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ColumnTest {

  @Test
  public void testAddAndRemoveTask() {
    Column column = new Column();
    Task task = new Task();
    // Test addTask
    column.addTask(task);
    assertTrue(column.getTasks().contains(task));

    // Test removeTask
    column.removeTask(task);
    assertFalse(column.getTasks().contains(task));
  }

  @Test
  public void testClearTasks() {
    Column column = new Column();
    Task task1 = new Task();
    Task task2 = new Task();
    column.addTask(task1);
    column.addTask(task2);

    column.clearTasks();
    assertTrue(column.getTasks().isEmpty());
  }
}