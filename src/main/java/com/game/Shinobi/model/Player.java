package com.game.Shinobi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer level;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private Set<Mob> army = new HashSet<>();

    @Column
    private Long userId;

    public Player(String name, Long userId)
    {
        this.name=name;
        this.level=1;
        this.userId=userId;

    }
    public void addMob(Mob mob) {
        this.army.add(mob);


    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id) && Objects.equals(name, player.name) && Objects.equals(level, player.level) &&Objects.equals(army, player.army)&&Objects.equals(userId, player.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, level,army,userId);
    }


//    @Override
//    public String toString(){
//        return "Player{"+
//                "name=" + name  +
//                ", level="+level+
//                ", army="+army.size()+
//                ", userId="+userId+
//                "}";
//    }

    public void removeMob(Mob mob) {
        army.remove(mob);
        mob.setPlayer(null);
    }
}
