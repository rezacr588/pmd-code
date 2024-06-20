package com.pmd.app.controller.TeamControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import com.pmd.app.service.TeamServices.ChatMessageService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ChatControllerTest {

  @Autowired
  private WebSocketStompClient stompClient;

  @MockBean
  private ChatMessageService chatMessageService;

}
