package com.pmd.app.service.TeamServices;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pmd.app.model.TeamModels.File;
import com.pmd.app.repository.TeamRepositories.FileRepository;

@ExtendWith(MockitoExtension.class)
public class FileServiceTest {

	@Mock
	private FileRepository fileRepository;

	@InjectMocks
	private FileService fileService;

	private File file;

	@BeforeEach
	void setUp() {
		file = new File();
		file.setId(1L);
		file.setName("TestFile");
		file.setType("text/plain");
		file.setCreatedBy(null); // Replace with a user object if necessary
	}

	@Test
	void testCreateFile() {
		when(fileRepository.save(any(File.class))).thenReturn(file);

		File createdFile = fileService.createFile(file);

		assertNotNull(createdFile);
		assertEquals(file.getId(), createdFile.getId());
		verify(fileRepository, times(1)).save(file);
	}

	@Test
	void testGetFile() {
		when(fileRepository.findById(1L)).thenReturn(Optional.of(file));

		Optional<File> foundFile = fileService.getFile(1L);

		assertTrue(foundFile.isPresent());
		assertEquals(file.getId(), foundFile.get().getId());
		verify(fileRepository, times(1)).findById(1L);
	}

	@Test
	void testGetAllFiles() {
		when(fileRepository.findAll()).thenReturn(Arrays.asList(file));

		List<File> files = fileService.getAllFiles();

		assertNotNull(files);
		assertEquals(1, files.size());
		verify(fileRepository, times(1)).findAll();
	}

	@Test
	void testUpdateFile() {
		when(fileRepository.save(any(File.class))).thenReturn(file);

		File updatedFile = fileService.updateFile(file);

		assertNotNull(updatedFile);
		assertEquals(file.getId(), updatedFile.getId());
		verify(fileRepository, times(1)).save(file);
	}

	@Test
	void testDeleteFile() {
		doNothing().when(fileRepository).deleteById(1L);

		fileService.deleteFile(1L);

		verify(fileRepository, times(1)).deleteById(1L);
	}

	@Test
	void testGetFilesByName() {
		when(fileRepository.findByName("TestFile")).thenReturn(Arrays.asList(file));

		List<File> files = fileService.getFilesByName("TestFile");

		assertNotNull(files);
		assertEquals(1, files.size());
		verify(fileRepository, times(1)).findByName("TestFile");
	}

	@Test
	void testGetFilesByType() {
		when(fileRepository.findByType("text/plain")).thenReturn(Arrays.asList(file));

		List<File> files = fileService.getFilesByType("text/plain");

		assertNotNull(files);
		assertEquals(1, files.size());
		verify(fileRepository, times(1)).findByType("text/plain");
	}

	@Test
	void testGetFilesCreatedByUser() {
		when(fileRepository.findByCreatedBy_Id(1L)).thenReturn(Arrays.asList(file));

		List<File> files = fileService.getFilesCreatedByUser(1L);

		assertNotNull(files);
		assertEquals(1, files.size());
		verify(fileRepository, times(1)).findByCreatedBy_Id(1L);
	}
}
