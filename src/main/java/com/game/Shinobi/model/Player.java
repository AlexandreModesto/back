package com.game.Shinobi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    @Column
    private String playerName;

    @Column
    private Integer playerLevel;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<Mob> army ;

    @Column
    private Long UserId;

    public Player(String playerName, Long userId)
    {
        this.playerName=playerName;
        this.playerLevel=1;
        this.UserId=userId;

    }
}
