package com.pmd.app.service.TeamServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.pmd.app.model.TeamModels.ChatMessage;
import com.pmd.app.repository.TeamRepositories.ChatMessageRepository;

@SpringBootTest
public class ChatMessageServiceTest {
	@Autowired
	private ChatMessageService chatMessageService;

	@MockBean
	private ChatMessageRepository chatMessageRepository;

	@Test
	public void getAllChatMessages() {
		List<ChatMessage> expected = new ArrayList<>();
		when(chatMessageRepository.findAll()).thenReturn(expected);

		List<ChatMessage> actual = chatMessageService.getAllChatMessages();

		assertEquals(expected, actual);
	}

	@Test
	public void getChatMessageById() {
		ChatMessage chatMessage = new ChatMessage();
		when(chatMessageRepository.findById(1L)).thenReturn(Optional.of(chatMessage));

		Optional<ChatMessage> actual = chatMessageService.getChatMessageById(1L);

		assertTrue(actual.isPresent());
		assertEquals(chatMessage, actual.get());
	}

	@Test
	public void saveChatMessage() {
		ChatMessage chatMessage = new ChatMessage();
		when(chatMessageRepository.save(chatMessage)).thenReturn(chatMessage);

		ChatMessage actual = chatMessageService.saveChatMessage(chatMessage);

		assertEquals(chatMessage, actual);
	}

	@Test
	public void deleteChatMessage() {
		doNothing().when(chatMessageRepository).deleteById(1L);

		chatMessageService.deleteChatMessage(1L);

		verify(chatMessageRepository, times(1)).deleteById(1L);
	}

	@Test
	public void getChatHistory() {
		List<ChatMessage> expected = new ArrayList<>();
		when(chatMessageRepository.findByChatGroup_Id(1L)).thenReturn(expected);

		List<ChatMessage> actual = chatMessageService.getChatHistory(1L);

		assertEquals(expected, actual);
	}
}
