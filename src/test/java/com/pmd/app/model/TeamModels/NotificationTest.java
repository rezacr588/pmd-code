package com.pmd.app.model.TeamModels;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

import com.pmd.app.model.User;

public class NotificationTest {
	@Test
	public void testNotificationModel() {
		User sender = new User();
		User receiver = new User();
		String message = "Welcome to the team!";
		LocalDateTime timestamp = LocalDateTime.now();

		Notification notification = new Notification();
		notification.setSender(sender);
		notification.setReceiver(receiver);
		notification.setMessage(message);
		notification.setTimestamp(timestamp);

		assertSame(sender, notification.getSender());
		assertSame(receiver, notification.getReceiver());
		assertEquals(message, notification.getMessage());
		assertEquals(timestamp, notification.getTimestamp());
	}
}
