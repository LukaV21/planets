package com.mi.planets.support.satellite;

import com.mi.planets.model.Satellite;
import com.mi.planets.service.PlanetService;
import com.mi.planets.service.SatelliteService;
import com.mi.planets.web.dto.SatelliteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SatelliteDtoToSatellite implements Converter<SatelliteDTO, Satellite> {
    @Autowired
    private SatelliteService satelliteService;
    @Autowired
    private PlanetService planetService;

    @Override
    public Satellite convert(SatelliteDTO dto) {
        Long id = dto.getId();
        Satellite satellite = id == null ? new Satellite() : satelliteService.findOne(id).get();

        if(satellite != null) {
            satellite.setName(dto.getName());
            satellite.setSurfaceArea(dto.getSurfaceArea());
            satellite.setMass(dto.getMass());
            satellite.setNaturalSatellite(dto.getNaturalSatellite());
            satellite.setPlanet(planetService.findOneById(dto.getPlanetId()));
        }

        return satellite;
    }

}
