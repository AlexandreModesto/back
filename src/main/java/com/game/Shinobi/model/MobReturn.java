package com.game.Shinobi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MobReturn {
    private MobType type;

    private String name;

    private String nickname;

    private String family;

    private String title;

    private int level;

    private int health;

    private int vigor;

    private int focus;

    private int cursedEnergy;

    private int experience;

    public MobReturn(Mob mob){
        this.type = mob.getType();
        this.name= mob.getName();
        this.nickname= mob.getNickname();
        this.family= mob.getFamily();
        this.title= mob.getTitle();
        this.level= mob.getLevel();
        this.health= mob.getHealth();
        this.vigor=mob.getVigor();
        this.focus= mob.getFocus();
        this.cursedEnergy=mob.getCursedEnergy();
        this.experience= mob.getExperience();
    }
}
