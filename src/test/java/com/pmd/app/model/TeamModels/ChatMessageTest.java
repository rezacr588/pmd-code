package com.pmd.app.model.TeamModels;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.pmd.app.model.User;

public class ChatMessageTest {
	@Test
	public void testChatMessage() {
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setId(1L);
		chatMessage.setContent("Test Message");

		assertEquals(1L, chatMessage.getId());
		assertEquals("Test Message", chatMessage.getContent());
	}

	@Test
	public void testChatMessageUser() {
		ChatMessage chatMessage = new ChatMessage();
		User user = new User();
		user.setId(1L);
		user.setUsername("Test User");

		chatMessage.setUser(user);

		assertEquals(1L, chatMessage.getUser().getId());
		assertEquals("Test User", chatMessage.getUser().getUsername());
	}

	@Test
	public void testChatMessageChatGroup() {
		ChatMessage chatMessage = new ChatMessage();
		ChatGroup chatGroup = new ChatGroup();
		chatGroup.setId(1L);
		chatGroup.setName("Test Group");

		chatMessage.setChatGroup(chatGroup);

		assertEquals(1L, chatMessage.getChatGroup().getId());
		assertEquals("Test Group", chatMessage.getChatGroup().getName());
	}
}
