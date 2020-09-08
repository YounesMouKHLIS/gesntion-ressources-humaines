package com.example.demo.team;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.RessourceNotFoundException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class TeamController {

	@Autowired
	private TeamRepository teamRepository;

	@GetMapping("/teams")
	public List<Team> getAllteams() {
		return teamRepository.findAll();
	}

	@PostMapping("/teams")
	public Team createTeam(@RequestBody Team team) {
		return teamRepository.save(team);
	}

	@GetMapping("/teams/{id}")
	public ResponseEntity<Team> getTeamById(@PathVariable long id) {
		Team team = teamRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Team not found with id =" + id));
		return ResponseEntity.ok(team);
	}

	@PutMapping("/teams/{id}")
	public ResponseEntity<Team> updateTask(@PathVariable long id, @RequestBody Team teamUpdt) {
		Team team = teamRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Employee not found with id =" + id));

		team.setDescription(teamUpdt.getDescription());
		team.setLibelle(teamUpdt.getLibelle());

		Team UpdateTeam = teamRepository.save(team);
		return ResponseEntity.ok(UpdateTeam);
	}
}