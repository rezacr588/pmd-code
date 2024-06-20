package com.pmd.app.model.TaskModels;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.pmd.app.model.Role;
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

  @Test
  public void updateColumns() {
    Project p = new Project("abc", new User("abc", "abc", "abc", new Role("abc")));
    List<Column> columns = new ArrayList<>();
    p.updateColumns(columns);
  }

  @Test
  public void clearColumns() {
    Project p = new Project("abc", new User("abc", "abc", "abc", new Role("abc")));
    p.clearColumns();
  }

  @Test
  public void setUser() {
    Project p = new Project("abc", new User("abc", "abc", "abc", new Role("abc")));
    User user = new User("abc", "abc", "abc", new Role("abc"));
    p.setUser(user);
  }

  @Test
  public void setId() {
    Project p = new Project("abc", new User("abc", "abc", "abc", new Role("abc")));
    Long id = 123L;
    p.setId(id);
  }

  @Test
  public void getId() {
    Project p = new Project("abc", new User("abc", "abc", "abc", new Role("abc")));
    Long id = 123L;
    p.setId(id);
    assertEquals(id, p.getId());

  }
}
