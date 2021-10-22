package com.mi.planets.service;


import com.mi.planets.model.Planet;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface PlanetService {

    Optional<Planet> findOne(Long id);

    Planet save(Planet planet);

    Page<Planet> findAllFiltered(String name, int page , int size);

    Planet findOneById(Long id);

    Planet update(Planet planet);

    Planet delete(Long id);

    Page<Planet> findAllSorted(int page, int size);
}
