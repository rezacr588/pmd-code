package com.pmd.app.controller.TeamControllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmd.app.model.TeamModels.Team;
import com.pmd.app.model.User;
import com.pmd.app.service.TeamServices.NotificationService;
import com.pmd.app.service.TeamServices.TeamService;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

  private final TeamService teamService;
  private final NotificationService notificationService;

  @Autowired
  public TeamController(TeamService teamService, NotificationService notificationService) {
    this.teamService = teamService;
    this.notificationService = notificationService;
  }

  @GetMapping
  public ResponseEntity<List<Team>> getAllTeams() {
    return ResponseEntity.ok(teamService.getAllTeams());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Team> getTeamById(@PathVariable Long id) {
    return teamService.getTeamById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Team> createTeam(@RequestBody Team team) {
    return ResponseEntity.ok(teamService.saveTeam(team));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Team> updateTeam(@PathVariable Long id, @RequestBody Team team) {
    return teamService.getTeamById(id)
        .map(existingTeam -> {
          team.setId(id);
          return ResponseEntity.ok(teamService.updateTeam(team));
        })
        .orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
    if (teamService.getTeamById(id).isPresent()) {
      teamService.deleteTeam(id);
      return ResponseEntity.ok().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/{teamId}/join")
  public ResponseEntity<Void> joinTeam(@PathVariable Long teamId, @RequestBody User user) {
    // Logic to add the user to the team...
    // After the user has been added to the team, send the notification:
    Optional<Team> optionalTeam = teamService.getTeamById(teamId);
    if (optionalTeam.isPresent()) {
      Team team = optionalTeam.get();
      notificationService.sendTeamJoinNotification(team, user);
      return ResponseEntity.ok().build();
    } else {
      // Handle the case where the team is not found
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/{teamId}/leave")
  public ResponseEntity<Void> leaveTeam(@PathVariable Long teamId, @RequestBody User user) {
    // Logic to remove the user from the team...
    // After the user has been removed from the team, send the notification:
    Optional<Team> optionalTeam = teamService.getTeamById(teamId);
    if (optionalTeam.isPresent()) {
      Team team = optionalTeam.get();
      notificationService.sendUserLeaveNotification(team, user);
      return ResponseEntity.ok().build();
    } else {
      // Handle the case where the team is not found
      return ResponseEntity.notFound().build();
    }
  }
}