package com.pmd.app.model.TaskModels;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ColumnTest {

  private Column column;
  private Project project;
  private Task task1;
  private Task task2;

  @BeforeEach
  void setUp() {
    project = new Project(); // Assume Project has a no-arg constructor
    project.setId(1L);
    column = new Column("To Do", 1, project);
    task1 = new Task(); // Assume Task has a no-arg constructor
    task1.setId(1L);
    task2 = new Task();
    task2.setId(2L);
  }

  @Test
  void testColumnCreation() {
    assertNotNull(column);
    assertEquals("To Do", column.getName());
    assertEquals(1, column.getOrder());
    assertEquals(project, column.getProject());
    assertTrue(column.getTasks().isEmpty());
  }

  @Test
  void testSetAndGetId() {
    column.setId(1L);
    assertEquals(1L, column.getId());
  }

  @Test
  void testSetAndGetName() {
    column.setName("In Progress");
    assertEquals("In Progress", column.getName());
  }

  @Test
  void testSetAndGetOrder() {
    column.setOrder(2);
    assertEquals(2, column.getOrder());
  }

  @Test
  void testSetAndGetProject() {
    Project newProject = new Project();
    newProject.setId(2L);
    column.setProject(newProject);
    assertEquals(newProject, column.getProject());
  }

  @Test
  void testAddTask() {
    column.addTask(task1);
    assertEquals(1, column.getTasks().size());
    assertTrue(column.getTasks().contains(task1));
  }

  @Test
  void testRemoveTask() {
    column.addTask(task1);
    column.addTask(task2);
    column.removeTask(task1);
    assertEquals(1, column.getTasks().size());
    assertFalse(column.getTasks().contains(task1));
    assertTrue(column.getTasks().contains(task2));
  }

  @Test
  void testClearTasks() {
    column.addTask(task1);
    column.addTask(task2);
    column.clearTasks();
    assertTrue(column.getTasks().isEmpty());
  }

  @Test
  void testSetTasks() {
    List<Task> tasks = new ArrayList<>();
    tasks.add(task1);
    tasks.add(task2);
    column.setTasks(tasks);
    assertEquals(2, column.getTasks().size());
    assertTrue(column.getTasks().contains(task1));
    assertTrue(column.getTasks().contains(task2));
  }

  @Test
  void testNoArgConstructor() {
    Column emptyColumn = new Column();
    assertNotNull(emptyColumn);
    assertNull(emptyColumn.getId());
    assertNull(emptyColumn.getName());
    assertNull(emptyColumn.getOrder());
    assertNull(emptyColumn.getProject());
    assertTrue(emptyColumn.getTasks().isEmpty());
  }
}