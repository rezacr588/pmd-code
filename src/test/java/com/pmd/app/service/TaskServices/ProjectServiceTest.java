package com.pmd.app.service.TaskServices;

import com.pmd.app.model.TaskModels.Project;
import com.pmd.app.repository.TasksRepositories.ProjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProjectServiceTest {

  @InjectMocks
  private ProjectService projectService;

  @Mock
  private ProjectRepository projectRepository;

  @BeforeEach
  public void init() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void createProjectTest() {
    Project project = new Project();
    when(projectRepository.save(project)).thenReturn(project);

    Project createdProject = projectService.createProject(project);

    assertEquals(createdProject, project);
    verify(projectRepository, times(1)).save(project);
  }

  @Test
  public void getProjectTest() {
    Project project = new Project();
    when(projectRepository.findById(1L)).thenReturn(Optional.of(project));

    Optional<Project> returnedProject = projectService.getProject(1L);

    assertEquals(returnedProject.get(), project);
    verify(projectRepository, times(1)).findById(1L);
  }

  @Test
  public void getAllProjectsTest() {
    Project project1 = new Project();
    Project project2 = new Project();
    List<Project> projects = Arrays.asList(project1, project2);

    when(projectRepository.findAll()).thenReturn(projects);

    List<Project> returnedProjects = projectService.getAllProjects();

    assertEquals(returnedProjects, projects);
    verify(projectRepository, times(1)).findAll();
  }

  @Test
  public void updateProjectTest() {
    Project project = new Project();
    when(projectRepository.save(project)).thenReturn(project);

    Project updatedProject = projectService.updateProject(project);

    assertEquals(updatedProject, project);
    verify(projectRepository, times(1)).save(project);
  }

  @Test
  public void deleteProjectTest() {
    doNothing().when(projectRepository).deleteById(1L);

    projectService.deleteProject(1L);

    verify(projectRepository, times(1)).deleteById(1L);
  }
}