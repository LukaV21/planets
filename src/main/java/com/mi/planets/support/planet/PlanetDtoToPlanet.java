package com.mi.planets.support.planet;

import com.mi.planets.model.Planet;
import com.mi.planets.model.Satellite;
import com.mi.planets.service.PlanetService;
import com.mi.planets.service.SatelliteService;
import com.mi.planets.web.dto.PlanetDTO;
import com.mi.planets.web.dto.SatelliteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlanetDtoToPlanet implements Converter<PlanetDTO, Planet> {
    @Autowired
    private PlanetService planetService;
    @Autowired
    private SatelliteService satelliteService;

    @Override
    public Planet convert(PlanetDTO source) {

        Planet planet;

        if(source.getId() == null) {
            planet = new Planet();
        }else {
            planet = planetService.findOneById(source.getId());
        }

        if(planet != null) {
            planet.setName(source.getName());
            planet.setSurfaceArea(source.getSurfaceArea());
            planet.setMass(source.getMass());
            planet.setDistanceFromSun(source.getDistanceFromSun());
            planet.setAverageSurfaceTemperature(source.getAverageSurfaceTemperature());

            if (source.getSatellites() != null) {
                List<Long> idSatellites = source.getSatellites().stream().map(SatelliteDTO::getId).collect(Collectors.toList());
                List<Satellite> satellites = satelliteService.find(idSatellites);
                planet.setSatellites(new ArrayList<>(satellites));
            }
        }
        return planet;
    }
}
