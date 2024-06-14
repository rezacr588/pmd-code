package com.pmd.app.model.TaskModels;

import javax.persistence.*;
import java.util.List;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "columns")
public class Column {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;
    private Integer order;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @NotNull
    private Project project;

    @OneToMany(mappedBy = "column", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Task> tasks;

    // constructors, getters, setters...

    public Column(String name, Integer order, Project project) {
      this.name = name;
      this.order = order;
      this.project = project;
    }
    
    public Column() {
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

    public Project getProject() {
      return project;
    }

    public void setProject(Project project) {
      this.project = project;
    }

    public List<Task> getTasks() {
      return tasks;
    }

    public void setTasks(List<Task> tasks) {
      this.tasks = tasks;
    }

    public void addTask(Task task) {
      this.tasks.add(task);
    }

    public void removeTask(Task task) {
      this.tasks.remove(task);
    }

    public void clearTasks() {
      this.tasks.clear();
    }
}