package com.pmd.app.repository.TasksRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pmd.app.model.TaskModels.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}