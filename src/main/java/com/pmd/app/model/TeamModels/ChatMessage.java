package com.pmd.app.model.TeamModels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.pmd.app.model.User;

@Entity
public class ChatMessage {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String content;

  @ManyToOne
  @JoinColumn(name = "chat_group_id")
  private ChatGroup chatGroup;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  // getters and setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public ChatGroup getChatGroup() {
    return chatGroup;
  }

  public void setChatGroup(ChatGroup chatGroup) {
    this.chatGroup = chatGroup;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}