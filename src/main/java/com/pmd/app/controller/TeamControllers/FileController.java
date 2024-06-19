package com.pmd.app.controller.TeamControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmd.app.model.TeamModels.File;
import com.pmd.app.service.TeamServices.FileService;

@RestController
@RequestMapping("/api/files")
public class FileController {

  private final FileService fileService;

  @Autowired
  public FileController(FileService fileService) {
    this.fileService = fileService;
  }

  // Create a new file
  @PostMapping
  public ResponseEntity<File> createFile(@RequestBody File file) {
    return ResponseEntity.ok(fileService.createFile(file));
  }

  // Get a file by id
  @GetMapping("/{id}")
  public ResponseEntity<File> getFile(@PathVariable Long id) {
    return ResponseEntity.of(fileService.getFile(id));
  }

  // Get all files
  @GetMapping
  public ResponseEntity<List<File>> getAllFiles() {
    return ResponseEntity.ok(fileService.getAllFiles());
  }

  // Update a file
  @PutMapping("/{id}")
  public ResponseEntity<File> updateFile(@PathVariable Long id, @RequestBody File file) {
    file.setId(id);
    return ResponseEntity.ok(fileService.updateFile(file));
  }

  // Delete a file
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteFile(@PathVariable Long id) {
    fileService.deleteFile(id);
    return ResponseEntity.noContent().build();
  }

  // Custom methods

  // Find files by name
  @GetMapping("/name/{name}")
  public ResponseEntity<List<File>> getFilesByName(@PathVariable String name) {
    return ResponseEntity.ok(fileService.getFilesByName(name));
  }

  // Find files by type
  @GetMapping("/type/{type}")
  public ResponseEntity<List<File>> getFilesByType(@PathVariable String type) {
    return ResponseEntity.ok(fileService.getFilesByType(type));
  }

  // Find files created by a specific user
  @GetMapping("/createdBy/{userId}")
  public ResponseEntity<List<File>> getFilesCreatedByUser(@PathVariable Long userId) {
    return ResponseEntity.ok(fileService.getFilesCreatedByUser(userId));
  }
}