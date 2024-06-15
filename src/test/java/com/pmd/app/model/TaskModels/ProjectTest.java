package com.pmd.app.model.TaskModels;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.pmd.app.model.User;

public class ProjectTest {

  @Test
  public void testAddAndRemoveColumn() {
    Project project = new Project();
    Column column = new Column();
    // Test addColumn
    project.addColumn(column);
    assertTrue(project.getColumns().contains(column));

    // Test removeColumn
    project.removeColumn(column);
    assertFalse(project.getColumns().contains(column));
  }

  @Test
  public void testUpdateProject() {
    Project project1 = new Project("Project 1", new User());
    Project project2 = new Project("Project 2", new User());

    Column column = new Column();
    List<Column> columns = new ArrayList<>();
    columns.add(column);
    project2.setColumns(columns);

    project1.updateProject(project2);

    assertEquals("Project 2", project1.getName());
    assertEquals(project2.getUser(), project1.getUser());
    assertEquals(columns, project1.getColumns());
  }
}