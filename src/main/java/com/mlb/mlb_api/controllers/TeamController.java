package com.mlb.mlb_api.controllers;


import com.mlb.mlb_api.controllers.dto.TeamDTO;
import com.mlb.mlb_api.repositories.entities.Team;
import com.mlb.mlb_api.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/team")
@CrossOrigin
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Team>> getAllTeams() {
        return ResponseEntity.ok().body(teamService.findAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity<Team> getTeamByName(@PathVariable String name) {
        return ResponseEntity.ok().body(teamService.findByTeamName(name));
    }

    @PostMapping("/add")
    public ResponseEntity<Team> createTeam(@RequestBody TeamDTO teamDTO) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/team/add").toUriString());
        return ResponseEntity.created(uri).body(teamService.save(teamDTO));
    }


    @PostMapping("/update")
    public ResponseEntity<Team> updateTeam(@RequestBody TeamDTO teamDTO) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/team/update").toUriString());
        return ResponseEntity.created(uri).body(teamService.updateTeam(teamDTO));
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<?> deleteTeam(@PathVariable String name) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/team/{name}").toUriString());
        teamService.deleteTeam(name);
        return ResponseEntity.ok(uri);
    }


}
