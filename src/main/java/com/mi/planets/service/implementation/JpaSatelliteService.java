package com.mi.planets.service.implementation;

import com.mi.planets.model.Satellite;
import com.mi.planets.repository.SatelliteRepository;
import com.mi.planets.service.SatelliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JpaSatelliteService implements SatelliteService {
    @Autowired
    private SatelliteRepository satelliteRepository;

    @Override
    public Optional<Satellite> findOne(Long id) {
        return satelliteRepository.findById(id);
    }

    @Override
    public List<Satellite> find(List<Long> idSatellites) {
        return satelliteRepository.findByIdIn(idSatellites);
    }

    @Override
    public Satellite save(Satellite satellite) {
        return satelliteRepository.save(satellite);
    }

    @Override
    public List<Satellite> findAllByPlanetId(Long id) {
        return satelliteRepository.findAllByPlanetId(id);
    }

    @Override
    public Satellite update(Satellite satellite) {
        return satelliteRepository.save(satellite);
    }


    @Override
    public Satellite delete(Long id) {
        Satellite satellite = satelliteRepository.findOneById(id);
        if(satellite != null){
            satellite.getPlanet().getSatellites().remove(satellite);
            satellite.setPlanet(null);
            satellite = satelliteRepository.save(satellite);
            satelliteRepository.delete(satellite);
            return satellite;
        }
        return null;
    }
}
