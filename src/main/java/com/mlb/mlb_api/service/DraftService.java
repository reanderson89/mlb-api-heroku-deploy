package com.mlb.mlb_api.service;

import com.mlb.mlb_api.controllers.dto.DraftDTO;
import com.mlb.mlb_api.repositories.entities.Draft;

public interface DraftService {

    Draft addPlayerToTeam(DraftDTO draftDTO);
    void removePlayerFromTeam(DraftDTO draftDTO);

}
