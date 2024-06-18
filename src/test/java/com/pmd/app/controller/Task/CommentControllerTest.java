package com.pmd.app.controller.Task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.pmd.app.model.TaskModels.Comment;
import com.pmd.app.service.TaskServices.CommentService;

public class CommentControllerTest {

  @InjectMocks
  CommentController commentController;

  @Mock
  CommentService commentService;

  @BeforeEach
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testCreateComment() {
    Comment comment = new Comment();
    when(commentService.createComment(comment)).thenReturn(comment);
    Comment result = commentController.createComment(comment);
    assertEquals(comment, result);
  }

  @Test
  public void testGetComment() {
    Comment comment = new Comment();
    when(commentService.getComment(1L)).thenReturn(java.util.Optional.of(comment));
    Comment result = commentController.getComment(1L);
    assertEquals(comment, result);
  }

  @Test
  public void testGetAllComments() {
    Comment comment = new Comment();
    when(commentService.getAllComments()).thenReturn(java.util.Arrays.asList(comment));
    java.util.List<Comment> result = commentController.getAllComments();
    assertEquals(1, result.size());
    assertEquals(comment, result.get(0));
  }

  @Test
  public void testUpdateComment() {
    Comment comment = new Comment();
    when(commentService.updateComment(comment)).thenReturn(comment);
    Comment result = commentController.updateComment(comment);
    assertEquals(comment, result);
  }

  @Test
  public void testDeleteComment() {
    doNothing().when(commentService).deleteComment(1L);
    commentController.deleteComment(1L);
  }
}