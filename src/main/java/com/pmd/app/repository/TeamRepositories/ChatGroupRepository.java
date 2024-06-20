package com.pmd.app.repository.TeamRepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmd.app.model.TeamModels.ChatGroup;

public interface ChatGroupRepository extends JpaRepository<ChatGroup, Long> {
}