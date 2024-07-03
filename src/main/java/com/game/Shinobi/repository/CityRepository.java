package com.game.Shinobi.repository;

import com.game.Shinobi.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CityRepository extends JpaRepository<City,Long> {
    @Query("Select c from City c where c.id =:id")
    public City getCityById(Long id);

    @Query("Select c from City c where c.cityName =:cityName")
    public City getCityNameByName(String cityName);
}
