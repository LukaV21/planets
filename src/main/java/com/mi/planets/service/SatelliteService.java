package com.mi.planets.service;

import com.mi.planets.model.Satellite;

import java.util.List;
import java.util.Optional;

public interface SatelliteService {
    Optional<Satellite> findOne(Long id);

    List<Satellite> find(List<Long> idSatellites);

    Satellite save(Satellite satellite);

    List<Satellite> findAllByPlanetId(Long id);

    Satellite update(Satellite satellite);

    Satellite delete(Long id);
}
