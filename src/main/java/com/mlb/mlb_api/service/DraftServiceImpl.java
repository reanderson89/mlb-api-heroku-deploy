package com.mlb.mlb_api.service;

import com.mlb.mlb_api.controllers.dto.DraftDTO;
import com.mlb.mlb_api.repositories.DraftRepository;
import com.mlb.mlb_api.repositories.entities.Draft;
import com.mlb.mlb_api.repositories.entities.Player;
import com.mlb.mlb_api.repositories.entities.Team;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service @Transactional
public class DraftServiceImpl implements DraftService{

    private final DraftRepository draftRepository;
    private final PlayerService playerService;
    private final TeamService teamService;

    public DraftServiceImpl(DraftRepository draftRepository, PlayerService playerService, TeamService teamService) {
        this.draftRepository = draftRepository;
        this.playerService = playerService;
        this.teamService = teamService;
    }

    @Override
    public Draft addPlayerToTeam(DraftDTO draftDTO) {
      Team team =  teamService.findById(draftDTO.getTeamId());
      Player draftedPlayer = playerService.findById(draftDTO.getPlayerId());
      draftedPlayer.setCurrentTeam(team.getName());
      team.addPlayerToRoster(draftDTO.getPlayerId());
      team.setBudget((team.getBudget()) - draftedPlayer.getCost());
        switch(draftedPlayer.getPosition()){
           case "first-base", "second-base", "third-base", "short-stop", "catcher" -> team.addPlayerToInfielders(draftedPlayer.getId());
            case "right-field", "left-field", "center-field" -> team.addPlayerToOutfielders(draftedPlayer.getId());
            case "pitcher" -> team.addPlayerToPitchers(draftedPlayer.getId());
        }
      return draftRepository.save(new Draft(draftDTO));
    }

    @Override
    public void removePlayerFromTeam(DraftDTO draftDTO) {

    }
}
