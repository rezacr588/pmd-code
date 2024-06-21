package com.pmd.app.service.TeamServices;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmd.app.model.TeamModels.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
  List<Notification> findByReceiverId(Long receiverId);
}