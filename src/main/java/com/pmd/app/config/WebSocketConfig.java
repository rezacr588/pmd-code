package com.pmd.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.pmd.app.model.User;
import com.pmd.app.repository.UserRepository;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
  @Autowired
  private UserRepository userRepository;

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/ws").setAllowedOrigins("*").withSockJS();
  }

  @Override
  public void configureMessageBroker(MessageBrokerRegistry registry) {
    registry.setApplicationDestinationPrefixes("/app");
    registry.enableSimpleBroker("/topic");
  }

  @EventListener
  public void handleSessionConnected(SessionConnectEvent event) {
    String username = event.getUser().getName();
    User user = userRepository.findByUsername(username);
    if (user != null) {
      user.setIsOnline(true);
      userRepository.save(user);
    }
  }

  @EventListener
  public void handleSessionDisconnect(SessionDisconnectEvent event) {
    String username = event.getUser().getName();
    User user = userRepository.findByUsername(username);
    if (user != null) {
      user.setIsOnline(false);
      userRepository.save(user);
    }
  }
}