package com.pmd.app.model.TeamModels;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.pmd.app.model.User;

public class TeamTest {
	@Test
	public void getId() {
		Team t = new Team();
		Long expected = 123L;
		t.setId(expected); // Set the id before calling getId
		Long actual = t.getId();

		assertEquals(expected, actual);
	}

	@Test
	public void setId() {
		Team t = new Team();
		Long id = 123L;
		t.setId(id);
	}

	@Test
	public void setName() {
		Team t = new Team();
		String name = "abc";
		t.setName(name);
	}

	@Test
	public void getMembers() {
		Team t = new Team();
		List<User> expected = new ArrayList<>();
		List<User> actual = t.getMembers();

		assertEquals(expected, actual);
	}

	@Test
	public void setMembers() {
		Team t = new Team();
		List<User> members = new ArrayList<>();
		t.setMembers(members);
	}

	@Test
	public void getName() {
		Team t = new Team();
		t.setName("abc");
		String expected = "abc";
		String actual = t.getName();

		assertEquals(expected, actual);
	}
}
