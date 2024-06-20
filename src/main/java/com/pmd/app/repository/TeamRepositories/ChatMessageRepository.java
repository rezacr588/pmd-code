package com.pmd.app.repository.TeamRepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmd.app.model.TeamModels.ChatMessage;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
}