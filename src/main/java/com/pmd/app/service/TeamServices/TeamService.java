package com.pmd.app.service.TeamServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmd.app.model.TeamModels.Team;
import com.pmd.app.repository.TeamRepositories.TeamRepository;

@Service
public class TeamService {

  private final TeamRepository teamRepository;

  @Autowired
  public TeamService(TeamRepository teamRepository) {
    this.teamRepository = teamRepository;
  }

  public List<Team> getAllTeams() {
    return teamRepository.findAll();
  }

  public Optional<Team> getTeamById(Long id) {
    return teamRepository.findById(id);
  }

  public Team saveTeam(Team team) {
    return teamRepository.save(team);
  }

  public Team updateTeam(Team team) {
    return teamRepository.save(team);
  }

  public void deleteTeam(Long id) {
    teamRepository.deleteById(id);
  }
}