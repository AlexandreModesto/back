package com.game.Shinobi.controller;

import com.game.Shinobi.model.Mob;
import com.game.Shinobi.model.MobProfileDTO;
import com.game.Shinobi.model.MobType;
import com.game.Shinobi.model.Player;
import com.game.Shinobi.repository.PlayerRepository;
import com.game.Shinobi.service.MobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/mob")
public class MobController {
    @Autowired
    MobService service;

    @Autowired
    PlayerRepository repository;


    @PostMapping(value = "/new/")
    public ResponseEntity<Object> createMob(@RequestBody Player player){
        Mob mob = new Mob(MobType.ALLY);
        mob.setPlayer(player);
        service.register(mob);
        Optional<Player> upt_player = repository.findById(player.getId());
        upt_player.get().getArmy().add(mob);
//        player.getArmy().add(mob);
        System.out.println(player);
        repository.save(player);
        return ResponseEntity.status(HttpStatus.OK).body(upt_player);
//        Optional<Player> player = repository.findById(player_id);
//        if(player.isPresent()) {
//            mob.setPlayer(player.get());
//            service.register(mob);
//            player.get().getArmy().add(mob);
//            System.out.println(player.get());
//            repository.save(player.get());
//            System.out.println(player.get());
//            return ResponseEntity.status(HttpStatus.OK).body(mob.getId());
//        }else {return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();}
    }

    @GetMapping(value = "/profile/")
    public ResponseEntity<?> getMobProfile(@RequestBody MobProfileDTO data){
        Optional<Mob> mob = service.mobInfo(data.mob_id());
        Optional<Player> player = repository.findById(data.player_id());
        if(player.isPresent() && mob.isPresent()) {
            if (player.get().getArmy().contains(mob.get())) {
                System.out.println(mob.get());
                return ResponseEntity.status(HttpStatus.OK).body(mob.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }else {return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();}
    }

    @GetMapping(value = "/army/")
    public ResponseEntity<List<Mob>> getArmy(@RequestBody Player player){
        return ResponseEntity.ok(player.getArmy());
    }
}
