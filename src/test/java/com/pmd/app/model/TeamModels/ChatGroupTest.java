package com.pmd.app.model.TeamModels;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.pmd.app.model.TaskModels.Task;
import com.pmd.app.model.User;

public class ChatGroupTest {
	@Test
	public void testChatGroup() {
		ChatGroup chatGroup = new ChatGroup();
		chatGroup.setId(1L);
		chatGroup.setName("Test Group");

		assertEquals(1L, chatGroup.getId());
		assertEquals("Test Group", chatGroup.getName());
	}

	@Test
	public void testChatGroupMessages() {
		ChatGroup chatGroup = new ChatGroup();
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setId(1L);
		chatMessage.setContent("Test Message");

		chatGroup.setMessages(List.of(chatMessage));

		assertEquals(1L, chatGroup.getMessages().get(0).getId());
		assertEquals("Test Message", chatGroup.getMessages().get(0).getContent());
	}

	@Test
	public void testChatGroupUsers() {
		ChatGroup chatGroup = new ChatGroup();
		User user = new User();
		user.setId(1L);
		user.setUsername("Test User");

		chatGroup.setUsers(List.of(user));

		assertEquals(1L, chatGroup.getUsers().get(0).getId());
		assertEquals("Test User", chatGroup.getUsers().get(0).getUsername());
	}

	@Test
	public void getTasks() {
		ChatGroup c = new ChatGroup();
		List<Task> expected = new ArrayList<>();
		List<Task> actual = c.getTasks();

		assertEquals(expected, actual);
	}

	@Test
	public void getId() {
		ChatGroup c = new ChatGroup();
		c.setId(123L);
		Long expected = 123L;
		Long actual = c.getId();

		assertEquals(expected, actual);
	}

	@Test
	public void getName() {
		ChatGroup c = new ChatGroup();
		c.setName("abc");
		String expected = "abc";
		String actual = c.getName();

		assertEquals(expected, actual);
	}

	@Test
	public void getMessages() {
		ChatGroup c = new ChatGroup();
		List<ChatMessage> expected = new ArrayList<>();
		List<ChatMessage> actual = c.getMessages();

		assertEquals(expected, actual);
	}

	@Test
	public void getUsers() {
		ChatGroup c = new ChatGroup();
		List<User> expected = new ArrayList<>();
		List<User> actual = c.getUsers();

		assertEquals(expected, actual);
	}

	@Test
	public void setTasks() {
		ChatGroup c = new ChatGroup();
		List<Task> expected = new ArrayList<>();
		c.setTasks(expected);
		List<Task> actual = c.getTasks();

		assertEquals(expected, actual);
	}

	@Test
	public void setId() {
		ChatGroup c = new ChatGroup();
		c.setId(123L);
		Long expected = 123L;
		Long actual = c.getId();

		assertEquals(expected, actual);
	}

	@Test
	public void setName() {
		ChatGroup c = new ChatGroup();
		c.setName("abc");
		String expected = "abc";
		String actual = c.getName();

		assertEquals(expected, actual);
	}

	@Test
	public void setMessages() {
		ChatGroup c = new ChatGroup();
		List<ChatMessage> expected = new ArrayList<>();
		c.setMessages(expected);
		List<ChatMessage> actual = c.getMessages();

		assertEquals(expected, actual);
	}

	@Test
	public void setUsers() {
		ChatGroup c = new ChatGroup();
		List<User> expected = new ArrayList<>();
		c.setUsers(expected);
		List<User> actual = c.getUsers();

		assertEquals(expected, actual);
	}

	@Test
	public void setStatus() {
		ChatGroup c = new ChatGroup();
		c.setStatus(true);
		Boolean expected = true;
		Boolean actual = c.getStatus();

		assertEquals(expected, actual);
	}

	@Test
	public void getStatus() {
		ChatGroup c = new ChatGroup();
		c.setStatus(true);
		Boolean expected = true;
		Boolean actual = c.getStatus();

		assertEquals(expected, actual);
	}

	@Test
	public void addUser() {
		ChatGroup c = new ChatGroup();
		User user = new User();
		c.addUser(user);
		List<User> expected = List.of(user);
		List<User> actual = c.getUsers();

		assertEquals(expected, actual);
	}

	@Test
	public void removeUser() {
		ChatGroup c = new ChatGroup();
		User user = new User();
		c.addUser(user);
		c.removeUser(user);
		List<User> expected = new ArrayList<>();
		List<User> actual = c.getUsers();

		assertEquals(expected, actual);
	}

	@Test
	public void addMessage() {
		ChatGroup c = new ChatGroup();
		ChatMessage message = new ChatMessage();
		c.addMessage(message);
		List<ChatMessage> expected = List.of(message);
		List<ChatMessage> actual = c.getMessages();

		assertEquals(expected, actual);
	}

	@Test
	public void removeMessage() {
		ChatGroup c = new ChatGroup();
		ChatMessage message = new ChatMessage();
		c.addMessage(message);
		c.removeMessage(message);
		List<ChatMessage> expected = new ArrayList<>();
		List<ChatMessage> actual = c.getMessages();

		assertEquals(expected, actual);
	}

}
