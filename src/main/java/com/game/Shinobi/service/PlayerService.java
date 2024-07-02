package com.game.Shinobi.service;

import com.game.Shinobi.model.Player;
import com.game.Shinobi.repository.PlayerRepository;
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
