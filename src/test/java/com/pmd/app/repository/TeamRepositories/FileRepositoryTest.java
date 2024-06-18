package com.pmd.app.repository.TeamRepositories;

import com.pmd.app.model.TeamModels.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class FileRepositoryTest {
	@Autowired
	private FileRepository fileRepository;

	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	public void findByName() {
		String name = "abc";
		List<File> expected = new ArrayList<>();
		List<File> actual = fileRepository.findByName(name);

		assertEquals(expected, actual);
	}
}
