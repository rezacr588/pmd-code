package com.pmd.app.service.TeamServices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;

import com.pmd.app.model.TeamModels.File;
import com.pmd.app.repository.TeamRepositories.FileRepository;

@SpringBootTest
public class FileServiceTest {

	@Mock
	private FileRepository fileRepository;

	@InjectMocks
	private FileService fileService;

	@Test
	public void testCreateFile() {
		File file = new File();
		file.setName("Test");

		when(fileRepository.save(any(File.class))).thenReturn(file);

		File createdFile = fileService.createFile(file);

		assertEquals(file.getName(), createdFile.getName());
	}

	@Test
	public void testGetFile() {
		File file = new File();
		file.setName("Test");

		when(fileRepository.findById(any(Long.class))).thenReturn(java.util.Optional.of(file));

		File foundFile = fileService.getFile(1L).get();

		assertEquals(file.getName(), foundFile.getName());
	}

	@Test
	public void testUpdateFile() {
		File file = new File();
		file.setName("Test");

		when(fileRepository.save(any(File.class))).thenReturn(file);

		File updatedFile = fileService.updateFile(file);

		assertEquals(file.getName(), updatedFile.getName());
	}

	@Test
	public void testDeleteFile() {
		fileService.deleteFile(1L);
	}

	@Test
	public void testGetFilesByName() {
		File file = new File();
		file.setName("Test");

		when(fileRepository.findByName(any(String.class))).thenReturn(java.util.Arrays.asList(file));

		assertEquals(file.getName(), fileService.getFilesByName("Test").get(0).getName());
	}
}