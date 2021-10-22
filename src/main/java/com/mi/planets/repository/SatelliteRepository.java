package com.mi.planets.repository;

import com.mi.planets.model.Satellite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SatelliteRepository extends JpaRepository<Satellite, Long> {
    List<Satellite> findByIdIn(List<Long> idSatellites);

    List<Satellite> findAllByPlanetId(Long id);

    Satellite findOneById(Long id);
}
