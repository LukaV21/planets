package com.mi.planets.service.implementation;

import com.mi.planets.model.Planet;
import com.mi.planets.repository.PlanetRepository;
import com.mi.planets.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JpaPlanetService implements PlanetService {

    @Autowired
    private PlanetRepository planetRepository;

    public JpaPlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }


    @Override
    public Optional<Planet> findOne(Long id) {
        return planetRepository.findById(id);
    }

    @Override
    public Planet save(Planet planet) {
        return planetRepository.save(planet);
    }

    @Override
    public Page<Planet> findAllFiltered(String name, int page, int size) {
        return planetRepository.findAllByNameIgnoreCaseContains(name, PageRequest.of(page, size));
    }

    @Override
    public Planet findOneById(Long id) {
        return planetRepository.findOneById(id);
    }

    @Override
    public Planet update(Planet planet) {
        return planetRepository.save(planet);
    }

    @Override
    public Planet delete(Long id) {
        Planet planet = planetRepository.findOneById(id);
        planetRepository.deleteById(id);
        return planet;
    }

    @Override
    public Page<Planet> findAllSorted(int page, int size) {
        return planetRepository.findAllSorted(PageRequest.of(page, size));
    }


}
