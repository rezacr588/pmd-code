package com.pmd.app.repository.TasksRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pmd.app.model.Column;

public interface ColumnRepository extends JpaRepository<Column, Long> {
}