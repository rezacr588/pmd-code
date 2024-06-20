package com.pmd.app.model.TeamModels;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pmd.app.model.User;

public class TeamTest {

	private Team team;
	private User user1;
	private User user2;
	private List<User> members;

	@BeforeEach
	void setUp() {
		user1 = new User();
		user1.setId(1L);
		user2 = new User();
		user2.setId(2L);
		members = new ArrayList<>();
		members.add(user1);
		members.add(user2);
	}

	@Test
	void testNoArgsConstructor() {
		team = new Team();
		assertNotNull(team);
		assertNull(team.getId());
		assertNull(team.getName());
		assertTrue(team.getMembers().isEmpty());
	}

	@Test
	void testConstructorWithNameAndMembers() {
		team = new Team("Test Team", members);
		assertEquals("Test Team", team.getName());
		assertEquals(2, team.getMembers().size());
		assertTrue(team.getMembers().contains(user1));
		assertTrue(team.getMembers().contains(user2));
	}

	@Test
	void testConstructorWithIdNameAndMembers() {
		team = new Team(1L, "Test Team", members);
		assertEquals(1L, team.getId());
		assertEquals("Test Team", team.getName());
		assertEquals(2, team.getMembers().size());
	}

	@Test
	void testConstructorWithName() {
		team = new Team("Test Team");
		assertEquals("Test Team", team.getName());
		assertTrue(team.getMembers().isEmpty());
	}

	@Test
	void testConstructorWithIdAndName() {
		team = new Team(1L, "Test Team");
		assertEquals(1L, team.getId());
		assertEquals("Test Team", team.getName());
		assertTrue(team.getMembers().isEmpty());
	}

	@Test
	void testConstructorWithNameMembersAndMember() {
		User newMember = new User();
		newMember.setId(3L);
		team = new Team("Test Team", members, newMember);
		assertEquals("Test Team", team.getName());
		assertEquals(3, team.getMembers().size());
		assertTrue(team.getMembers().contains(newMember));
	}

	@Test
	void testConstructorWithNameAndMember() {
		team = new Team("Test Team", user1);
		assertEquals("Test Team", team.getName());
		assertEquals(1, team.getMembers().size());
		assertTrue(team.getMembers().contains(user1));
	}

	@Test
	void testConstructorWithIdNameAndMember() {
		team = new Team(1L, "Test Team", user1);
		assertEquals(1L, team.getId());
		assertEquals("Test Team", team.getName());
		assertEquals(1, team.getMembers().size());
		assertTrue(team.getMembers().contains(user1));
	}

	@Test
	void testSetAndGetId() {
		team = new Team();
		team.setId(1L);
		assertEquals(1L, team.getId());
	}

	@Test
	void testSetAndGetName() {
		team = new Team();
		team.setName("New Team Name");
		assertEquals("New Team Name", team.getName());
	}

	@Test
	void testSetAndGetMembers() {
		team = new Team();
		team.setMembers(members);
		assertEquals(2, team.getMembers().size());
		assertTrue(team.getMembers().contains(user1));
		assertTrue(team.getMembers().contains(user2));
	}
}