package com.game.Shinobi.service;

import com.game.Shinobi.model.Mob;
import com.game.Shinobi.model.Player;
import com.game.Shinobi.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository repository;

    public Player playerInfo(Long id){
        return repository.findById(id).orElse(null);
    }
    public Player checkPlayerNameAlreadyExists(String playerName)
    {
        Player player = repository.getPlayerByPlayerName(playerName);
        return player;
    }

    public void register(Player player)
    {
        repository.save(player);
    }

    public Set<Mob> getArmy (Long id){
        Player player= repository.findById(id).orElse(null);
        if(player ==null){
            return null;
        }
        return player.getArmy();
    }

    public List<Player> getAllPlayers()
    {
        return repository.findAll();
    }

}
