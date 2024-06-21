package com.pmd.app.controller.TeamControllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmd.app.model.TeamModels.Notification;
import com.pmd.app.service.TeamServices.NotificationService;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

  private final NotificationService notificationService;

  public NotificationController(NotificationService notificationService) {
    this.notificationService = notificationService;
  }

  @GetMapping("/{userId}")
  public ResponseEntity<List<Notification>> getMissedNotificationsForUser(@PathVariable Long userId) {
    List<Notification> notifications = notificationService.getMissedNotificationsForUser(userId);
    return ResponseEntity.ok(notifications);
  }
}
