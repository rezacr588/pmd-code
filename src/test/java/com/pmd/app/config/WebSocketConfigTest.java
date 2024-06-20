package com.pmd.app.config;

import java.security.Principal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.pmd.app.model.User;
import com.pmd.app.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class WebSocketConfigTest {
	@InjectMocks
	private WebSocketConfig webSocketConfig;

	@Mock
	private UserRepository userRepository;

	@Mock
	private SessionConnectEvent sessionConnectEvent;

	@Mock
	private SessionDisconnectEvent sessionDisconnectEvent;

	@Mock
	private User user;

	@Mock
	private Principal principal;

	@BeforeEach
	public void setup() {
		lenient().when(sessionConnectEvent.getUser()).thenReturn(principal);
		lenient().when(sessionDisconnectEvent.getUser()).thenReturn(principal);
		lenient().when(principal.getName()).thenReturn("username");
	}

	@Test
	public void testHandleSessionConnectedUserNotFound() {
		Mockito.lenient().when(userRepository.findByUsername("username")).thenReturn(null);
		webSocketConfig.handleSessionConnected(sessionConnectEvent);
		verify(user, times(0)).setIsOnline(true);
		verify(userRepository, times(0)).save(user);
	}

	@Test
	public void testHandleSessionDisconnect() {
		Mockito.lenient().when(userRepository.findByUsername("username")).thenReturn(user);
		webSocketConfig.handleSessionDisconnect(sessionDisconnectEvent);
		verify(user).setIsOnline(false);
		verify(userRepository).save(user);
	}

	@Test
	public void testHandleSessionDisconnectUserNotFound() {
		Mockito.lenient().when(userRepository.findByUsername("username")).thenReturn(null);
		webSocketConfig.handleSessionDisconnect(sessionDisconnectEvent);
		verify(user, times(0)).setIsOnline(false);
		verify(userRepository, times(0)).save(user);
	}
}
