package com.pmd.app.model.TeamModels;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

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
}
