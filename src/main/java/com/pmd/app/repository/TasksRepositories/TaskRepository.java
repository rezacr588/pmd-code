package com.pmd.app.repository.TasksRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pmd.app.model.TaskModels.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}