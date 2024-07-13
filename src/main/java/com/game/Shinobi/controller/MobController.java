package com.game.Shinobi.controller;

import com.game.Shinobi.model.*;
import com.game.Shinobi.service.MobService;
import com.game.Shinobi.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "/mob")
public class MobController {
    @Autowired
    MobService mobService;

    @Autowired
    PlayerService playerService;


    @PostMapping(value = "/new/")
    public ResponseEntity<?> createMob(@RequestBody MobCreateDTO data){
        Mob mob = new Mob(MobType.ALLY);
        Player player = playerService.playerInfo(data.player_id());
        if(player!=null) {
            mob.setPlayer(player);
            mobService.register(mob);
            player.addMob(mob);

            playerService.register(player);
            return ResponseEntity.ok().body(mob.getId());
        }else {return ResponseEntity.notFound().build();}
    }

    @GetMapping(value = "/profile/")
    public ResponseEntity<?> getMobProfile(@RequestBody MobProfileDTO data){
        Mob mob = mobService.mobInfo(data.mob_id());
        Player player = playerService.playerInfo(data.player_id());
        if(player !=null && mob != null) {
            if(player.getArmy().contains(mob)){
                MobReturn returnMob = new MobReturn(mob);
                return ResponseEntity.ok(returnMob);
            }else {return ResponseEntity.notFound().build();}
        }else {return ResponseEntity.badRequest().build();}
//        if(playerOptional.isPresent() && mob.isPresent()) {
//            if (playerOptional.get().getArmy().contains(mob.get())) {
//                System.out.println(mob.get());
//                return ResponseEntity.status(HttpStatus.OK).body(mob.get());
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//            }
//        }else {return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();}
    }

    @GetMapping(value = "/army{id}/")
    public ResponseEntity<Set<Mob>> getArmy(@PathVariable Long id){
        Set<Mob> army = playerService.getArmy(id);
        if (army==null){
            return ResponseEntity.notFound().build();
        }else return ResponseEntity.ok(army);
    }
}
