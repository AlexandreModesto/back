package com.game.Shinobi.repository;

import com.game.Shinobi.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlayerRepository extends JpaRepository<Player,Long> {
    @Query("Select p from Player p where p.id = :id")
    public Player getPlayerById(Long id);

    @Query("Select p from Player p where p.name =:name")
    public Player getPlayerByPlayerName(String name);
}
