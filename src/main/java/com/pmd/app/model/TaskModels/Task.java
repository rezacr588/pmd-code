package com.pmd.app.model.TaskModels;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pmd.app.model.TeamModels.ChatGroup;

@Entity
@Table(name = "tasks")
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull
  @Size(max = 100)
  private String name;

  @NotNull
  private Integer order;

  @NotNull
  private Boolean status;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "column_id")
  private Column column;

  @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<TaskUser> taskUsers = new ArrayList<>();;

  @ManyToMany(mappedBy = "tasks")
  private List<ChatGroup> chatGroups;

  public Task() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getOrder() {
    return order;
  }

  public void setOrder(Integer order) {
    this.order = order;
  }

  public Column getColumn() {
    return column;
  }

  public void setColumn(Column column) {
    this.column = column;
  }

  public List<TaskUser> getTaskUsers() {
    return taskUsers;
  }

  public void setTaskUsers(List<TaskUser> taskUsers) {
    this.taskUsers = taskUsers;
  }

  public void addTaskUser(TaskUser taskUser) {
    this.taskUsers.add(taskUser);
  }

  public void removeTaskUser(TaskUser taskUser) {
    this.taskUsers.remove(taskUser);
  }

  public void clearTaskUsers() {
    this.taskUsers.clear();
  }

  public List<ChatGroup> getChatGroups() {
    return chatGroups;
  }

  public void setChatGroups(List<ChatGroup> chatGroups) {
    this.chatGroups = chatGroups;
  }

  public void addChatGroup(ChatGroup chatGroup) {
    this.chatGroups.add(chatGroup);
  }

  public void removeChatGroup(ChatGroup chatGroup) {
    this.chatGroups.remove(chatGroup);
  }

  public void clearChatGroups() {
    this.chatGroups.clear();
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

}