package com.game.Shinobi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Random;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Mob {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @Column
    private MobType type;

    @Column
    private String name;

    @Column
    private String nickname;

    @Column
    private String family;

    @Column
    private String title;

    @Column
    private int level;

    @Column
    private int health;

    @Column
    private int vigor;

    @Column
    private int focus;

    @Column
    private int cursedEnergy;

    @Column
    private int experience;

    public Mob(MobType type){
        Random random = new Random();
        this.name = "Mob Teste "+random.nextInt(10)+1;
        this.level=1;
        this.health=random.nextInt(10) + 1;
        this.vigor=random.nextInt(10) + 1;
        this.focus=random.nextInt(10) + 1;
        this.cursedEnergy=random.nextInt(10) + 1;
        this.experience=0;
        this.type=type;

    }


    public void levelUp(){
        this.level++;
        this.health++;
        this.vigor++;
        this.focus++;
        this.cursedEnergy++;
        this.experience=0;

        if(this.level==5){
            this.nickname=" O Apelido";
            this.name+=this.nickname;
        }
    }

//    public String profile(){
//        return String.format("{name:%s,level:%d,type:%s,family:%s,title:%s,health:%d,vigor:%d,focus:%d,cursedEnergy:%d,experience:%d}",
//                this.name,this.level,this.type,
//                this.family,this.title,this.health,
//                this.vigor,this.focus,this.cursedEnergy,this.experience);
//    }

}
