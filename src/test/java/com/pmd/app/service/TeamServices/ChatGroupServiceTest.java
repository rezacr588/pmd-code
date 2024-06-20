package com.pmd.app.service.TeamServices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.pmd.app.model.TeamModels.ChatGroup;
import com.pmd.app.model.User;
import com.pmd.app.repository.TeamRepositories.ChatGroupRepository;

@SpringBootTest
public class ChatGroupServiceTest {
	@Autowired
	private ChatGroupService chatGroupService;

	@MockBean
	private ChatGroupRepository chatGroupRepository;

	@Test
	public void getAllChatGroups() {
		List<ChatGroup> expected = new ArrayList<>();
		List<ChatGroup> actual = chatGroupService.getAllChatGroups();

		assertEquals(expected, actual);
	}

	@Test
	public void testGetAllChatGroups() {
		ChatGroup chatGroup = new ChatGroup();
		when(chatGroupRepository.findAll()).thenReturn(Arrays.asList(chatGroup));

		List<ChatGroup> result = chatGroupService.getAllChatGroups();

		assertEquals(1, result.size());
		verify(chatGroupRepository, times(1)).findAll();
	}

	@Test
	public void testGetChatGroupById() {
		ChatGroup chatGroup = new ChatGroup();
		when(chatGroupRepository.findById(1L)).thenReturn(java.util.Optional.of(chatGroup));

		assertEquals(chatGroup, chatGroupService.getChatGroup(1L).get());
		verify(chatGroupRepository, times(1)).findById(1L);
	}

	@Test
	public void testSaveChatGroup() {
		ChatGroup chatGroup = new ChatGroup();
		when(chatGroupRepository.save(chatGroup)).thenReturn(chatGroup);

		assertEquals(chatGroup, chatGroupService.saveChatGroup(chatGroup));
		verify(chatGroupRepository, times(1)).save(chatGroup);
	}

	@Test
	public void testDeleteChatGroup() {
		chatGroupService.deleteChatGroup(1L);

		verify(chatGroupRepository, times(1)).deleteById(1L);
	}

	@Test
	public void testRemoveUserFromGroup() {
		ChatGroup chatGroup = new ChatGroup();
		User user = new User();
		chatGroup.addUser(user);

		when(chatGroupRepository.findById(1L)).thenReturn(java.util.Optional.of(chatGroup));

		chatGroupService.removeUserFromGroup(chatGroup, user);

		assertFalse(chatGroup.getUsers().contains(user));
		verify(chatGroupRepository, times(1)).save(chatGroup);
	}

	@Test
	public void testCloseChatGroup() {
		ChatGroup chatGroup = new ChatGroup();
		chatGroup.setStatus(true);

		when(chatGroupRepository.findById(1L)).thenReturn(java.util.Optional.of(chatGroup));

		chatGroupService.closeChatGroup(1L);
		chatGroup.setStatus(false);

		assertFalse(chatGroup.getStatus());
		verify(chatGroupRepository, times(1)).save(chatGroup);
	}
}
