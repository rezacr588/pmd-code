package com.pmd.app.repository.TasksRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.pmd.app.model.TaskModels.Column;
import com.pmd.app.model.TaskModels.Comment;
import com.pmd.app.model.TaskModels.Project;
import com.pmd.app.model.TaskModels.Task;
import com.pmd.app.repository.TasksRepositories.ColumnRepository;
import com.pmd.app.repository.TasksRepositories.CommentRepository;
import com.pmd.app.repository.TasksRepositories.ProjectRepository;
import com.pmd.app.repository.TasksRepositories.TaskRepository;

@DataJpaTest
public class RepositoryTests {

  @Autowired
  private TaskRepository taskRepository;

  @Autowired
  private ProjectRepository projectRepository;

  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  private ColumnRepository columnRepository;

  @Test
  public void testSaveAndGetTask() {
    Task task = new Task();
    // set properties for task
    taskRepository.save(task);

    Optional<Task> foundTask = taskRepository.findById(task.getId());
    assertTrue(foundTask.isPresent());
    assertEquals(task.getId(), foundTask.get().getId());
    // add more assertions for other properties
  }

  @Test
  public void testSaveAndGetProject() {
    Project project = new Project();
    // set properties for project
    projectRepository.save(project);

    Optional<Project> foundProject = projectRepository.findById(project.getId());
    assertTrue(foundProject.isPresent());
    assertEquals(project.getId(), foundProject.get().getId());
    // add more assertions for other properties
  }

  @Test
  public void testSaveAndGetComment() {
    Comment comment = new Comment();
    // set properties for comment
    commentRepository.save(comment);

    Optional<Comment> foundComment = commentRepository.findById(comment.getId());
    assertTrue(foundComment.isPresent());
    assertEquals(comment.getId(), foundComment.get().getId());
    // add more assertions for other properties
  }

  @Test
  public void testSaveAndGetColumn() {
    Column column = new Column();
    // set properties for column
    columnRepository.save(column);

    Optional<Column> foundColumn = columnRepository.findById(column.getId());
    assertTrue(foundColumn.isPresent());
    assertEquals(column.getId(), foundColumn.get().getId());
    // add more assertions for other properties
  }

  @Test
  public void testDeleteTask() {
    Task task = new Task();
    // set properties for task
    taskRepository.save(task);
    taskRepository.delete(task);

    Optional<Task> foundTask = taskRepository.findById(task.getId());
    assertFalse(foundTask.isPresent());
  }

  @Test
  public void testDeleteProject() {
    Project project = new Project();
    // set properties for project
    projectRepository.save(project);
    projectRepository.delete(project);

    Optional<Project> foundProject = projectRepository.findById(project.getId());
    assertFalse(foundProject.isPresent());
  }

  @Test
  public void testDeleteComment() {
    Comment comment = new Comment();
    // set properties for comment
    commentRepository.save(comment);
    commentRepository.delete(comment);

    Optional<Comment> foundComment = commentRepository.findById(comment.getId());
    assertFalse(foundComment.isPresent());
  }

  @Test
  public void testDeleteColumn() {
    Column column = new Column();
    // set properties for column
    columnRepository.save(column);
    columnRepository.delete(column);

    Optional<Column> foundColumn = columnRepository.findById(column.getId());
    assertFalse(foundColumn.isPresent());
  }
}