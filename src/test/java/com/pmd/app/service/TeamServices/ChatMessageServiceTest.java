package com.pmd.app.service.TeamServices;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
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
		List<ChatMessage> actual = chatMessageService.getAllChatMessages();

		assertEquals(expected, actual);
	}

}
