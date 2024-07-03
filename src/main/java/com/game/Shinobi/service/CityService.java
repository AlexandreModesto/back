package com.game.Shinobi.service;

import com.game.Shinobi.model.City;
import com.game.Shinobi.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    CityRepository repository;

    public City cityInfo(Long id){
        City city = repository.getCityById(id);
        return city;
    }
    public City checkIfCityNameAlreadyExists(String cityName){
        City city = repository.getCityNameByName(cityName);
        return city;
    }

    public void registerCity(City city){
        repository.save(city);
    }
}
