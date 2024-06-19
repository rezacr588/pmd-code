package com.pmd.app.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@ExtendWith(MockitoExtension.class)
public class WebSocketConfigTest {

	@InjectMocks
	private WebSocketConfig webSocketConfig;

	@Mock
	private MessageBrokerRegistry messageBrokerRegistry;

	@Mock
	private StompEndpointRegistry stompEndpointRegistry;

	@Test
	public void shouldConfigureMessageBroker() {
		webSocketConfig.configureMessageBroker(messageBrokerRegistry);
		verify(messageBrokerRegistry).setApplicationDestinationPrefixes("/app");
		verify(messageBrokerRegistry).enableSimpleBroker("/topic");
	}
}
