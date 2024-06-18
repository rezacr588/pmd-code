package com.pmd.app.repository.TeamRepositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmd.app.model.TeamModels.File;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {

  // Custom methods

  // Find files by name
  List<File> findByName(String name);

  // Find files by type
  List<File> findByType(String type);

  // Find files created by a specific user
  List<File> findByCreatedBy_Id(Long userId);
}