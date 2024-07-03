package com.game.Shinobi.controller;

import com.game.Shinobi.model.City;
import com.game.Shinobi.model.CityDTO;
import com.game.Shinobi.model.Player;
import com.game.Shinobi.repository.PlayerRepository;
import com.game.Shinobi.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "city/")
public class CityController {
    @Autowired
    CityService service;

    @Autowired
    PlayerRepository playerRepository;

    @PostMapping(value = "/create/")
    public ResponseEntity<?> register(@RequestBody @Validated CityDTO data){
        if (service.checkIfCityNameAlreadyExists(data.cityName()) != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }else {
            Player player = playerRepository.getPlayerById(data.player_id());
            City newCity = new City(data.cityName(),player);
            service.registerCity(newCity);
            return ResponseEntity.status(HttpStatus.OK).body(newCity.getId());
        }
    }

    @GetMapping(value = "/info/{id}")
    public ResponseEntity<?> info(@PathVariable(value = "id")Long id){
        City city =service.cityInfo(id);
        if(city != null){
            return ResponseEntity.ok(city);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

}
