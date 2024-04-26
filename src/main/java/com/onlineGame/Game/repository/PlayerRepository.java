package com.onlineGame.Game.repository;

import com.onlineGame.Game.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlayerRepository extends JpaRepository<Player,Long> {

    @Query("Select p from Player p where p.id = :id")
    public Player getPlayerById(Long id);

    @Query("Select p from Player p where p.playerName =:playerName")
    public Player getPlayerByPlayerName(String playerName);
}
