package com.game.Shinobi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String cityName;

    @OneToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @Column
    private Integer wood;

    @Column
    private Integer steel;

    @Column
    private Integer iron;

    @Column
    private Integer gold;

    public City(String cityName, Player player){
        this.cityName=cityName;
        this.player=player;
        this.gold=0;
        this.steel=0;
        this.wood=0;
        this.iron=0;
    }
}
