package com.pmd.app.service.TeamServices;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.pmd.app.model.TeamModels.Notification;
import com.pmd.app.model.TeamModels.Team;
import com.pmd.app.model.User;

@Service
public class NotificationService {

  private final SimpMessagingTemplate template;
  private final JsonService jsonService;
  private final NotificationRepository notificationRepository;

  public NotificationService(SimpMessagingTemplate template, JsonService jsonService,
      NotificationRepository notificationRepository) {
    this.template = template;
    this.jsonService = jsonService;
    this.notificationRepository = notificationRepository;
  }

  public void sendTeamJoinNotification(Team team, User newMember) {
    for (User member : team.getMembers()) {
      Notification notification = new Notification();
      notification.setSender(newMember);
      notification.setReceiver(member);
      notification.setMessage(newMember.getUsername() + " has joined the team.");
      notification.setTimestamp(LocalDateTime.now());

      String notificationJson = jsonService.convertToJson(notification);

      template.convertAndSend("/topic/team/" + team.getId(), notificationJson);
    }
  }

  public void sendUserLeaveNotification(Team team, User leavingMember) {
    for (User member : team.getMembers()) {
      if (!member.equals(leavingMember)) {
        Notification notification = new Notification();
        notification.setSender(leavingMember);
        notification.setReceiver(member);
        notification.setMessage(leavingMember.getUsername() + " has left the team.");
        notification.setTimestamp(LocalDateTime.now());

        String notificationJson = jsonService.convertToJson(notification);

        template.convertAndSend("/topic/team/" + team.getId(), notificationJson);
      }
    }
  }

  public List<Notification> getMissedNotificationsForUser(Long userId) {
    // Implement the logic to fetch missed notifications for a user.
    // This will likely involve calling a method on the NotificationRepository.
    return notificationRepository.findByReceiverId(userId);
  }
}