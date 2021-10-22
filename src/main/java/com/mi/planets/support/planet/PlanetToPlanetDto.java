package com.mi.planets.support.planet;

import com.mi.planets.model.Planet;
import com.mi.planets.model.Satellite;
import com.mi.planets.support.satellite.SatelliteToSatelliteDto;
import com.mi.planets.web.dto.PlanetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlanetToPlanetDto implements Converter<Planet, PlanetDTO> {
    @Autowired
    private SatelliteToSatelliteDto toSatelliteDto;
    @Override
    public PlanetDTO convert(Planet source) {
        PlanetDTO dto = new PlanetDTO();

        dto.setId(source.getId());
        dto.setName(source.getName());
        dto.setSurfaceArea(source.getSurfaceArea());
        dto.setMass(source.getMass());
        dto.setDistanceFromSun(source.getDistanceFromSun());
        dto.setAverageSurfaceTemperature(source.getAverageSurfaceTemperature());

        List<Satellite> satellites = new ArrayList<>(source.getSatellites());
        dto.setSatellites(new ArrayList<>(toSatelliteDto.convert(satellites)));

        return dto;
    }

    public List<PlanetDTO> convert(List<Planet> planets){
        List<PlanetDTO> dtos = new ArrayList<>();

        for(Planet planet : planets) {
            PlanetDTO planetDTO = convert(planet);
            dtos.add(planetDTO);
        }

        return dtos;
    }}
