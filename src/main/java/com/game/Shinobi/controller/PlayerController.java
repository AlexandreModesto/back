package com.game.Shinobi.controller;

import com.game.Shinobi.model.Player;
import com.game.Shinobi.model.RegisterDTO;
import com.game.Shinobi.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/player")
public class PlayerController {
    @Autowired
    PlayerService service;

    @GetMapping(value = "/info/{id}")
    public ResponseEntity<?> info(@PathVariable(value = "id")Long id){
        Player player = service.playerInfo(id);
        if (player != null){
            return ResponseEntity.ok(player);}
        else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/new")
    public ResponseEntity<?> register(@RequestBody @Validated RegisterDTO data){
        if (service.checkPlayerNameAlreadyExists(data.playerName()) != null )
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("PLAYERNAME");
        }else
        {
            Player newPlayer = new Player(data.playerName(),data.userId());
            service.registerPlayer(newPlayer);

            return ResponseEntity.status(HttpStatus.OK).body(newPlayer.getId());
        }
    }
    @GetMapping(value = "/all-players")
    public ResponseEntity<List<Player>> getAllPlayers()
    {
        List<Player> registedPlayers = service.getAllPlayers();
        return ResponseEntity.ok(registedPlayers);
    }
}
