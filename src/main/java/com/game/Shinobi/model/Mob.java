package com.game.Shinobi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Random;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Mob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mob mob = (Mob) o;
        return Objects.equals(id, mob.id) && Objects.equals(name, mob.name) && Objects.equals(level, mob.level) && Objects.equals(health, mob.health)&& Objects.equals(vigor, mob.vigor)&& Objects.equals(focus, mob.focus)&& Objects.equals(cursedEnergy, mob.cursedEnergy)&& Objects.equals(experience, mob.experience)&& Objects.equals(type, mob.type)&& Objects.equals(player, mob.player)&& Objects.equals(nickname, mob.nickname)&& Objects.equals(family, mob.family)&& Objects.equals(title, mob.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, level,health,vigor,focus,cursedEnergy,experience,type,nickname,family,title);
    }

    @Override
    public String toString(){
        return "Mob{"+
                "name=" + name  +
                ", type="+type+
                ", nickname="+nickname+
                ", family="+family+
                ", title="+title+
                ", level="+level+
                ", health="+health+
                ", vigor="+vigor+
                ", focus="+focus+
                ", cursedEnergy="+cursedEnergy+
                ", experience="+experience+
                ", player_id="+player.getId()+
        "}";
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
