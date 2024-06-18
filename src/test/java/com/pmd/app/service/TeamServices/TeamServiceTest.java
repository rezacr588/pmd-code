package com.pmd.app.service.TeamServices;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pmd.app.model.TeamModels.Team;
import com.pmd.app.repository.TeamRepositories.TeamRepository;

@ExtendWith(MockitoExtension.class)
public class TeamServiceTest {

	@Mock
	private TeamRepository teamRepository;

	@InjectMocks
	private TeamService teamService;

	@Test
	public void testGetAllTeams() {
		Team team1 = new Team();
		Team team2 = new Team();
		List<Team> teams = Arrays.asList(team1, team2);

		when(teamRepository.findAll()).thenReturn(teams);

		List<Team> result = teamService.getAllTeams();

		assertEquals(teams, result);
	}

	@Test
	public void testGetTeamById() {
		Team team = new Team();
		team.setId(1L);

		when(teamRepository.findById(1L)).thenReturn(Optional.of(team));

		Optional<Team> result = teamService.getTeamById(1L);

		assertEquals(team, result.orElse(null));
	}

	@Test
	public void testSaveTeam() {
		Team team = new Team();

		when(teamRepository.save(any(Team.class))).thenReturn(team);

		Team result = teamService.saveTeam(new Team());

		assertEquals(team, result);
	}

	@Test
	public void testUpdateTeam() {
		Team team = new Team();

		when(teamRepository.save(any(Team.class))).thenReturn(team);

		Team result = teamService.updateTeam(new Team());

		assertEquals(team, result);
	}

	@Test
	public void testDeleteTeam() {
		Long id = 1L;

		doNothing().when(teamRepository).deleteById(id);

		teamService.deleteTeam(id);

		verify(teamRepository, times(1)).deleteById(id);
	}
}