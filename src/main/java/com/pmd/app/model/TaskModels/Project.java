package com.pmd.app.model.TaskModels;

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

import com.pmd.app.model.User;

@Entity
@Table(name = "projects")
public class Project {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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

  public Project(String name, User user) {
    this.name = name;
    this.user = user;
  }

  public Project() {
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

  @Override
  public String toString() {
    return "Project{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", user=" + user +
        ", columns=" + columns +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Project project = (Project) o;

    if (!id.equals(project.id))
      return false;
    if (!name.equals(project.name))
      return false;
    if (!user.equals(project.user))
      return false;
    return columns.equals(project.columns);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + name.hashCode();
    result = 31 * result + user.hashCode();
    result = 31 * result + columns.hashCode();
    return result;
  }
}