package com.mlb.mlb_api.service;

import com.mlb.mlb_api.controllers.dto.TeamDTO;
import com.mlb.mlb_api.repositories.TeamRepository;
import com.mlb.mlb_api.repositories.entities.Team;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService{

    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Iterable<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public Team findByTeamName(String name) {
        return teamRepository.findByName(name);
    }

    @Override
    public Team save(TeamDTO teamDTO) {
        Team team = new Team(teamDTO);
        return teamRepository.save(team);
    }

    @Override
    public Team updateTeam(TeamDTO teamDTO) {
        Team team = findByTeamName(teamDTO.getName());

        team.setName(teamDTO.getName());
        team.setLocation(teamDTO.getLocation());

        return team;
    }

    @Override
    public void deleteTeam(String name) {
        if(teamRepository.existsByName(name)){
            teamRepository.deleteByName(name);
        }
    }

    @Override
    public Team findById(Integer id) {
        Optional<Team> optionalTeam = teamRepository.findById(id);
        if(optionalTeam.isEmpty()){
            return null;
        }

        return optionalTeam.get();
    }
}
