package com.onlineGame.Game.controller;


import com.onlineGame.Game.models.Player;
import com.onlineGame.Game.models.RegisterDTO;
import com.onlineGame.Game.service.PlayerService;
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
    public ResponseEntity<?> info(@PathVariable(value = "id") Long id){
        Player player=service.playerInfo(id);
        return ResponseEntity.ok(player);
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

            return ResponseEntity.status(HttpStatus.OK).build();
        }
    }
    @GetMapping(value = "/all-players")
    public ResponseEntity<List<Player>> getAllPlayers()
    {
        List<Player> registedPlayers = service.getAllPlayers();
        return ResponseEntity.ok(registedPlayers);
    }
}
