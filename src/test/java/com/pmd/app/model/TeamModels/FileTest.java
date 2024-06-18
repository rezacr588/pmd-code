package com.pmd.app.model.TeamModels;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.pmd.app.model.User;

public class FileTest {
	@Test
	void testConstructor() {
		Long id = 1L;
		String name = "Test";
		String type = "Type";
		byte[] data = new byte[10];
		Team team = new Team();
		User createdBy = new User();
		String downloadLink = "www.download.com";

		File file = new File(id, name, type, data, team, createdBy, downloadLink);

		assertEquals(id, file.getId());
		assertEquals(name, file.getName());
		assertEquals(type, file.getType());
		assertArrayEquals(data, file.getData());
		assertEquals(team, file.getTeam());
		assertEquals(createdBy, file.getCreatedBy());
		assertEquals(downloadLink, file.getDownloadLink());
	}

	@Test
	void testSetters() {
		Long id = 1L;
		String name = "Test";
		String type = "Type";
		byte[] data = new byte[10];
		Team team = new Team();
		User createdBy = new User();
		String downloadLink = "www.download.com";

		File file = new File();
		file.setId(id);
		file.setName(name);
		file.setType(type);
		file.setData(data);
		file.setTeam(team);
		file.setCreatedBy(createdBy);
		file.setDownloadLink(downloadLink);

		assertEquals(id, file.getId());
		assertEquals(name, file.getName());
		assertEquals(type, file.getType());
		assertArrayEquals(data, file.getData());
		assertEquals(team, file.getTeam());
		assertEquals(createdBy, file.getCreatedBy());
		assertEquals(downloadLink, file.getDownloadLink());
	}
}
