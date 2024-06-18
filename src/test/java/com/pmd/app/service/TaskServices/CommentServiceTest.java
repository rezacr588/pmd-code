package com.pmd.app.service.TaskServices;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.pmd.app.model.TaskModels.Comment;
import com.pmd.app.repository.TasksRepositories.CommentRepository;

public class CommentServiceTest {

  @InjectMocks
  private CommentService commentService;

  @Mock
  private CommentRepository commentRepository;

  @BeforeEach
  public void init() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void createCommentTest() {
    Comment comment = new Comment();
    when(commentRepository.save(comment)).thenReturn(comment);

    Comment createdComment = commentService.createComment(comment);

    assertEquals(createdComment, comment);
    verify(commentRepository, times(1)).save(comment);
  }

  @Test
  public void getAllCommentsTest() {
    Comment comment1 = new Comment();
    Comment comment2 = new Comment();
    List<Comment> comments = Arrays.asList(comment1, comment2);
    when(commentRepository.findAll()).thenReturn(comments);

    List<Comment> returnedComments = commentService.getAllComments();

    assertEquals(returnedComments, comments);
    verify(commentRepository, times(1)).findAll();
  }

  @Test
  public void updateCommentTest() {
    Comment comment = new Comment();
    when(commentRepository.save(comment)).thenReturn(comment);

    Comment updatedComment = commentService.updateComment(comment);

    assertEquals(updatedComment, comment);
    verify(commentRepository, times(1)).save(comment);
  }

  @Test
  public void deleteCommentTest() {
    Long id = 1L;
    Mockito.doNothing().when(commentRepository).deleteById(id);

    commentService.deleteComment(id);

    verify(commentRepository, times(1)).deleteById(id);
  }
}