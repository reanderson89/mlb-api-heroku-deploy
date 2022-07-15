package com.mlb.mlb_api.controllers;


import com.mlb.mlb_api.controllers.dto.DraftDTO;
import com.mlb.mlb_api.repositories.entities.Draft;
import com.mlb.mlb_api.service.DraftService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/draft")
public class DraftController {

    private final DraftService draftService;

    public DraftController(DraftService draftService) {
        this.draftService = draftService;
    }

    @PostMapping("/add")
    public ResponseEntity<Draft> addPlayerToTeam(@RequestBody DraftDTO draftDTO){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/draft/add").toUriString());
        return ResponseEntity.created(uri).body(draftService.addPlayerToTeam(draftDTO));
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> removePlayerFromTeam(@RequestBody DraftDTO draftDTO){
        draftService.removePlayerFromTeam(draftDTO);
        return ResponseEntity.ok().body(null);
    }
}
