package com.mlb.mlb_api.controllers;


import com.mlb.mlb_api.controllers.dto.PlayerDTO;
import com.mlb.mlb_api.repositories.entities.Player;
import com.mlb.mlb_api.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/player")
@CrossOrigin()
public class PlayerController {


    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/add")
    public ResponseEntity<Player> createPlayer(@RequestBody PlayerDTO newPlayerDTO){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/player/add").toUriString());
        return ResponseEntity.created(uri).body(playerService.save(newPlayerDTO));
    }


    @GetMapping
    public ResponseEntity<Iterable<Player>> getPlayer(){
        return ResponseEntity.ok(playerService.findAll());
    }

    @GetMapping("/find")
    public ResponseEntity<Player> findPlayerByName(@RequestParam String name){
        return ResponseEntity.ok(playerService.findByName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable("id") Integer playerId){
       return ResponseEntity.ok(playerService.findById(playerId));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Player> updatePlayer(@RequestBody PlayerDTO playerDTO, @PathVariable("id") Integer playerId){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/update/add").toUriString());
        return ResponseEntity.created(uri).body(playerService.update(playerDTO, playerId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable("id") Integer playerId){
        playerService.delete(playerId);
       return ResponseEntity.ok(null);
    }

}










