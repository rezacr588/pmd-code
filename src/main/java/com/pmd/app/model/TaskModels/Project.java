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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.pmd.app.model.TeamModels.Team;
import com.pmd.app.model.User;

@Entity
@Table(name = "projects")
public class Project {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @NotNull
  private Long id;

  @NotNull
  private String name;

  @ManyToOne
  @JoinColumn(name = "user_id")
  @NotNull
  private User user;

  @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Column> columns;

  @ManyToOne
  @JoinColumn(name = "team_id")
  private Team team;

  public Project(String name, User user) {
    this.name = name;
    this.user = user;
    this.columns = new ArrayList<>();
  }

  public Project() {
    this.columns = new ArrayList<>();
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

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<Column> getColumns() {
    return columns;
  }

  public void setColumns(List<Column> columns) {
    this.columns = columns;
  }

  public void addColumn(Column column) {
    this.columns.add(column);
  }

  public void removeColumn(Column column) {
    this.columns.remove(column);
  }

  public void clearColumns() {
    this.columns.clear();
  }

  public void updateColumns(List<Column> columns) {
    this.columns.clear();
    this.columns.addAll(columns);
  }

  public void updateProject(Project project) {
    this.name = project.getName();
    this.user = project.getUser();
    this.columns = project.getColumns();
  }

  public Team getTeam() {
    return team;
  }

  public void setTeam(Team team) {
    this.team = team;
  }
}