package com.pmd.app.model.TeamModels;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.pmd.app.model.User;

@Entity
@Table(name = "teams")
public class Team {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @ManyToMany
  @JoinTable(name = "team_members", joinColumns = @JoinColumn(name = "team_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
  private List<User> members;

  // Getters and setters
  public Team() {
    this.members = new ArrayList<>();
  }

  public Team(String name, List<User> members) {
    this.name = name;
    this.members = members != null ? members : new ArrayList<>();
  }

  public Team(Long id, String name, List<User> members) {
    this.id = id;
    this.name = name;
    this.members = members != null ? members : new ArrayList<>();
  }

  public Team(String name) {
    this.name = name;
    this.members = new ArrayList<>();
  }

  public Team(Long id, String name) {
    this.id = id;
    this.name = name;
    this.members = new ArrayList<>();
  }

  public Team(String name, User member) {
    this.name = name;
    this.members = new ArrayList<>();
    this.members.add(member);
  }

  public Team(Long id, String name, User member) {
    this.id = id;
    this.name = name;
    this.members = new ArrayList<>();
    this.members.add(member);
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

  public List<User> getMembers() {
    return members;
  }

  public void setMembers(List<User> members) {
    this.members = members;
  }
}
