package com.pmd.app.model.TeamModels;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.pmd.app.model.TaskModels.Task;
import com.pmd.app.model.User;

@Entity
public class ChatGroup {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "chatGroup")
  private List<ChatMessage> messages;

  @ManyToMany
  @JoinTable(name = "chatgroup_user", joinColumns = @JoinColumn(name = "chatgroup_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
  private List<User> users;

  @ManyToMany
  @JoinTable(name = "chatgroup_task", joinColumns = @JoinColumn(name = "chatgroup_id"), inverseJoinColumns = @JoinColumn(name = "task_id"))
  private List<Task> tasks;

  @NotNull
  private Boolean status;

  // getters and setters
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

  public List<ChatMessage> getMessages() {
    return messages;
  }

  public void setMessages(List<ChatMessage> messages) {
    this.messages = messages;
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

  public List<Task> getTasks() {
    return tasks;
  }

  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

  public void addUser(User user) {
    this.users.add(user);
  }

  public void removeUser(User user) {
    this.users.remove(user);
  }

  public void addMessage(ChatMessage message) {
    this.messages.add(message);
  }

  public void removeMessage(ChatMessage message) {
    this.messages.remove(message);
  }

  @Override
  public String toString() {
    return "ChatGroup [id=" + id + ", name=" + name + ", messages=" + messages + ", users=" + users + ", task=" + task
        + ", status=" + status + "]";
  }

}
