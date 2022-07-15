package com.mlb.mlb_api.service;

import com.mlb.mlb_api.controllers.dto.TeamDTO;
import com.mlb.mlb_api.repositories.entities.Team;



public interface TeamService {
    Iterable<Team> findAll();
    Team findByTeamName(String name);
    Team save(TeamDTO teamDTO);
    Team updateTeam(TeamDTO teamDTO);
    void deleteTeam(String name);
    Team findById(Integer id);

}
