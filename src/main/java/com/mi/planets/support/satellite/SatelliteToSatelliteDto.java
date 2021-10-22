package com.mi.planets.support.satellite;

import com.mi.planets.model.Satellite;
import com.mi.planets.web.dto.SatelliteDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SatelliteToSatelliteDto implements Converter<Satellite, SatelliteDTO> {
    @Override
    public SatelliteDTO convert(Satellite source) {
        SatelliteDTO dto = new SatelliteDTO();
        dto.setId(source.getId());
        dto.setName(source.getName());
        dto.setSurfaceArea(source.getSurfaceArea());
        dto.setMass(source.getMass());
        dto.setNaturalSatellite(source.getNaturalSatellite());

        dto.setPlanetId(source.getPlanet().getId());
        dto.setPlanetName(source.getPlanet().getName());
        return dto;
    }

    public List<SatelliteDTO> convert(List<Satellite> sources){
        List<SatelliteDTO> satelliteDTOS = new ArrayList<>();

        for(Satellite a : sources) {
            SatelliteDTO dto = convert(a);
            satelliteDTOS.add(dto);
        }
        return satelliteDTOS;
    }
}
