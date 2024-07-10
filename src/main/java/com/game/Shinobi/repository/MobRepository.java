package com.game.Shinobi.repository;

import com.game.Shinobi.model.Mob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MobRepository extends JpaRepository<Mob,Long> {

}
