package com.onlineGame.Game.service;


import com.onlineGame.Game.models.Player;
import com.onlineGame.Game.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository repository;

    public Player playerInfo(Long id){
        Player player = repository.getPlayerById(id);

        return player;
    }

     public Player checkPlayerNameAlreadyExists(String playerName)
     {
         Player player = repository.getPlayerByPlayerName(playerName);
         return player;
     }

     public void registerPlayer(Player player)
     {
         repository.save(player);
     }

     public List<Player> getAllPlayers()
     {
         return repository.findAll();
     }
}
