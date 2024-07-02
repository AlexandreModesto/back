package com.game.Shinobi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column
    private Long UserId;

    public Player(String playerName, Long userId)
    {
        this.playerName=playerName;
        this.playerLevel=1;
        this.UserId=userId;
    }
}
