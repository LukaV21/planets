package com.mi.planets.web.controller;

import com.mi.planets.model.Satellite;
import com.mi.planets.service.SatelliteService;
import com.mi.planets.support.satellite.SatelliteDtoToSatellite;
import com.mi.planets.support.satellite.SatelliteToSatelliteDto;
import com.mi.planets.web.dto.SatelliteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/satellites", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiSatelliteController {
    @Autowired
    private SatelliteService satelliteService;
    @Autowired
    private SatelliteToSatelliteDto toSatelliteDto;
    @Autowired
    private SatelliteDtoToSatellite toSatellite;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SatelliteDTO> create(@Valid @RequestBody SatelliteDTO dto){
        Satellite satellite = toSatellite.convert(dto);
        Satellite saved = satelliteService.save(satellite);
        return new ResponseEntity<>(toSatelliteDto.convert(saved), HttpStatus.CREATED);
    }

    @GetMapping("/planet/{id}")
    public ResponseEntity<List<SatelliteDTO>> getAllSatellitesForPlanet(@PathVariable Long id) {
        List<Satellite> satellites = satelliteService.findAllByPlanetId(id);
        return new ResponseEntity<>(toSatelliteDto.convert(satellites), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SatelliteDTO> getOne(@PathVariable Long id){
        Satellite satellite = satelliteService.findOne(id).get();
        if(satellite != null) {
            return new ResponseEntity<>(toSatelliteDto.convert(satellite), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SatelliteDTO> update(@PathVariable Long id, @Valid @RequestBody SatelliteDTO dto){

        if(!id.equals(dto.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Satellite satellite = toSatellite.convert(dto);
        Satellite saved = satelliteService.update(satellite);

        return new ResponseEntity<>(toSatelliteDto.convert(saved),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Satellite deleted = satelliteService.delete(id);

        if(deleted != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}
