package com.game.Shinobi.service;

import com.game.Shinobi.model.Mob;
import com.game.Shinobi.repository.MobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MobService {

    @Autowired
    public MobRepository repository;

    public Mob mobInfo(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Mob> getArmy(){
        return repository.findAll();
    }

    public void kill(Long id){
        repository.deleteById(id);
    }

    public void register(Mob mob){repository.save(mob);}
}
