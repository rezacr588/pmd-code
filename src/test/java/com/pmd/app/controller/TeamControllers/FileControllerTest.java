package com.pmd.app.controller.TeamControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.pmd.app.model.TeamModels.File;
import com.pmd.app.service.TeamServices.FileService;

@WebMvcTest(FileController.class)
public class FileControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FileService fileService;

	private File file;
}
