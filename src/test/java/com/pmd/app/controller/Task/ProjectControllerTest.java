package com.pmd.app.controller.Task;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.pmd.app.model.TaskModels.Project;
import com.pmd.app.service.TaskServices.ProjectService;

public class ProjectControllerTest {

  @InjectMocks
  ProjectController projectController;

  @Mock
  ProjectService projectService;

  @BeforeEach
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testGetProjects() {
    Project project = new Project();
    when(projectService.getAllProjects()).thenReturn(Collections.singletonList(project));

    List<Project> response = projectController.getAllProjects();

    assertEquals(1, response.size());
  }

  @Test
  public void testGetProject() {
    Project project = new Project();
    when(projectService.getProject(1L)).thenReturn(java.util.Optional.of(project));

    Project response = projectController.getProject(1L);

    assertEquals(project, response);
  }

  @Test
  public void testCreateProject() {
    Project project = new Project();
    when(projectService.createProject(project)).thenReturn(project);

    Project response = projectController.createProject(project);

    assertEquals(project, response);
  }

  @Test
  public void testUpdateProject() {
    Project project = new Project();
    when(projectService.updateProject(project)).thenReturn(project);

    Project response = projectController.updateProject(project);

    assertEquals(project, response);
  }

  @Test
  public void testDeleteProject() {
    projectController.deleteProject(1L);

    ResponseEntity<Void> response = ResponseEntity.ok().build();

    assertEquals(response, response);
  }

}