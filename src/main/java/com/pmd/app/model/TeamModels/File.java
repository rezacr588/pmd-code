package com.pmd.app.model.TeamModels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.pmd.app.model.User;

@Entity
public class File {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String type;

  private byte[] data;

  @ManyToOne
  private Team team;

  @ManyToOne
  private User createdBy;

  private String downloadLink;

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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }

  public Team getTeam() {
    return team;
  }

  public void setTeam(Team team) {
    this.team = team;
  }

  public User getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(User createdBy) {
    this.createdBy = createdBy;
  }

  public String getDownloadLink() {
    return downloadLink;
  }

  public void setDownloadLink(String downloadLink) {
    this.downloadLink = downloadLink;
  }

  public File(Long id, String name, String type, byte[] data, Team team, User createdBy, String downloadLink) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.data = data;
    this.team = team;
    this.createdBy = createdBy;
    this.downloadLink = downloadLink;
  }

  public File() {
  }

  public File(String name, String type, byte[] data, Team team, User createdBy, String downloadLink) {
    this.name = name;
    this.type = type;
    this.data = data;
    this.team = team;
    this.createdBy = createdBy;
    this.downloadLink = downloadLink;
  }

  public File(String name, String type, byte[] data, Team team, User createdBy) {
    this.name = name;
    this.type = type;
    this.data = data;
    this.team = team;
    this.createdBy = createdBy;
  }

  public File(String name, String type, byte[] data, Team team) {
    this.name = name;
    this.type = type;
    this.data = data;
    this.team = team;
  }

  public File(String name, String type, byte[] data) {
    this.name = name;
    this.type = type;
    this.data = data;
  }

  public File(String name, String type) {
    this.name = name;
    this.type = type;
  }

  public File(String name) {
    this.name = name;
  }

  public File(Long id, String name, String type, byte[] data) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.data = data;
  }

  public File(Long id, String name, String type) {
    this.id = id;
    this.name = name;
    this.type = type;
  }

  public File(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public File(Long id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "File [createdBy=" + createdBy + ", data=" + data + ", downloadLink=" + downloadLink + ", id=" + id
        + ", name=" + name + ", team=" + team + ", type=" + type + "]";
  }

}