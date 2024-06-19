package com.pmd.app.service.TeamServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmd.app.model.TeamModels.File;
import com.pmd.app.repository.TeamRepositories.FileRepository;

@Service
public class FileService {

  private final FileRepository fileRepository;

  @Autowired
  public FileService(FileRepository fileRepository) {
    this.fileRepository = fileRepository;
  }

  // Create a new file
  public File createFile(File file) {
    return fileRepository.save(file);
  }

  // Get a file by id
  public Optional<File> getFile(Long id) {
    return fileRepository.findById(id);
  }

  // Get all files
  public List<File> getAllFiles() {
    return fileRepository.findAll();
  }

  // Update a file
  public File updateFile(File file) {
    return fileRepository.save(file);
  }

  // Delete a file
  public void deleteFile(Long id) {
    fileRepository.deleteById(id);
  }

  // Custom methods

  // Find files by name
  public List<File> getFilesByName(String name) {
    return fileRepository.findByName(name);
  }

  // Find files by type
  public List<File> getFilesByType(String type) {
    return fileRepository.findByType(type);
  }

  // Find files created by a specific user
  public List<File> getFilesCreatedByUser(Long userId) {
    return fileRepository.findByCreatedBy_Id(userId);
  }
}