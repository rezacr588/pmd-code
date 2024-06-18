package com.pmd.app.controller.TeamControllers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.pmd.app.model.TeamModels.Team;
import com.pmd.app.service.TeamServices.TeamService;

@ExtendWith(MockitoExtension.class)
public class TeamControllerTest {

	@Mock
	private TeamService teamService;

	@InjectMocks
	private TeamController teamController;

	@Test
	public void testGetAllTeams() {
		Team team1 = new Team();
		Team team2 = new Team();
		List<Team> teams = Arrays.asList(team1, team2);

		when(teamService.getAllTeams()).thenReturn(teams);

		ResponseEntity<List<Team>> result = teamController.getAllTeams();

		assertEquals(teams, result.getBody());
	}

	@Test
	public void testGetTeamById() {
		Team team = new Team();
		team.setId(1L);

		when(teamService.getTeamById(1L)).thenReturn(Optional.of(team));

		ResponseEntity<Team> result = teamController.getTeamById(1L);

		assertEquals(team, result.getBody());
	}

	@Test
	public void testCreateTeam() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		Team team = new Team();

		when(teamService.saveTeam(any(Team.class))).thenReturn(team);

		ResponseEntity<Team> result = teamController.createTeam(new Team());

		assertEquals(team, result.getBody());
	}

	@Test
	public void testUpdateTeam() {
		Team team = new Team();

		when(teamService.getTeamById(1L)).thenReturn(Optional.of(team));
		when(teamService.updateTeam(any(Team.class))).thenReturn(team);

		ResponseEntity<Team> result = teamController.updateTeam(1L, new Team());

		assertEquals(team, result.getBody());
	}

	@Test
	public void testDeleteTeam() {
		Team team = new Team();

		when(teamService.getTeamById(1L)).thenReturn(Optional.of(team));

		ResponseEntity<Void> result = teamController.deleteTeam(1L);

		assertEquals(200, result.getStatusCodeValue());
	}
}