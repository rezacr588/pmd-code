package com.pmd.app.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "tasks")
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Size(max = 100)
  private String name;

  @NotNull
  private Integer order;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "column_id")
  private Column column;

  @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<TaskUser> taskUsers;

    // constructors, getters, setters...

    public Task(String name, Integer order, Column column) {
      this.name = name;
      this.order = order;
      this.column = column;
    }
    
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

}