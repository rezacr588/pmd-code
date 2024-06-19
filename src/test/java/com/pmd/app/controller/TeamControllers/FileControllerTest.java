package com.pmd.app.controller.TeamControllers;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.pmd.app.model.TeamModels.File;
import com.pmd.app.service.TeamServices.FileService;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser // This annotation will mock a user, bypassing the security
public class FileControllerTest {

	@Mock
	private FileService fileService;

	@InjectMocks
	private FileController fileController;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testCreateFile() throws Exception {
		File file = new File();
		file.setName("file");
		file.setType("type");
		file.setData("data".getBytes());
		file.setDownloadLink("link");

		when(fileService.createFile(any(File.class))).thenReturn(file);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/files")
				.with(csrf()) // This will add a CSRF token, if CSRF protection is enabled
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"file\",\"type\":\"type\",\"data\":\"data\",\"downloadLink\":\"link\"}"))
				.andExpect(status().isOk());
	}

	@Test
	public void testGetFile() throws Exception {
		File file = new File();
		file.setId(1L);
		file.setName("file");
		file.setType("type");
		file.setData("data".getBytes());
		file.setDownloadLink("link");

		when(fileService.getFile(1L)).thenReturn(java.util.Optional.of(file));

		mockMvc.perform(MockMvcRequestBuilders.get("/api/files/1")
				.with(csrf())) // This will add a CSRF token, if CSRF protection is enabled
				.andExpect(status().isOk());
	}

}