package com.pmd.app.model.TaskModels;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CommentTest {

  @Test
  public void testComment() {
    Comment comment = new Comment();
    String content = "Test content";
    Task task = new Task();

    comment.setContent(content);
    comment.setTask(task);

    assertEquals(content, comment.getContent());
    assertEquals(task, comment.getTask());

    // Test createdAt and updatedAt
    // Please note that this is a simplified test and might fail if the execution
    // time between the creation and the assertion is too long
    LocalDateTime beforeCreation = LocalDateTime.now();
    comment.onCreate();
    LocalDateTime afterCreation = LocalDateTime.now();
    assertTrue(comment.getCreatedAt().isEqual(beforeCreation) || comment.getCreatedAt().isAfter(beforeCreation));
    assertTrue(comment.getCreatedAt().isBefore(afterCreation) || comment.getCreatedAt().isEqual(afterCreation));

    LocalDateTime beforeUpdate = LocalDateTime.now();
    comment.onUpdate();
    LocalDateTime afterUpdate = LocalDateTime.now();
    assertTrue(comment.getUpdatedAt().isEqual(beforeUpdate) || comment.getUpdatedAt().isAfter(beforeUpdate));
    assertTrue(comment.getUpdatedAt().isBefore(afterUpdate) || comment.getUpdatedAt().isEqual(afterUpdate));
  }
}