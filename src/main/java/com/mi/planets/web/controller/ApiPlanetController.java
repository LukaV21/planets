package com.mi.planets.web.controller;

import com.mi.planets.model.Planet;
import com.mi.planets.service.PlanetService;
import com.mi.planets.support.planet.PlanetDtoToPlanet;
import com.mi.planets.support.planet.PlanetToPlanetDto;
import com.mi.planets.web.dto.PlanetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/planets", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiPlanetController {
    @Autowired
    private PlanetService planetService;
    @Autowired
    private PlanetToPlanetDto toPlanetDto;
    @Autowired
    private PlanetDtoToPlanet toPlanet;



    @GetMapping
    public ResponseEntity<List<PlanetDTO>> getAllPlanets(
            @RequestParam(required=false,  defaultValue= "") String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size )
    {
        Page<Planet> planets = planetService.findAllFiltered(name, page, size);
        return new ResponseEntity<>(toPlanetDto.convert(planets.getContent()), HttpStatus.OK);
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<PlanetDTO>> getAllPlanetsSorted(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size )
    {
        Page<Planet> planets = planetService.findAllSorted(page, size);
        return new ResponseEntity<>(toPlanetDto.convert(planets.getContent()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanetDTO> get(@PathVariable Long id){
        Optional<Planet> planet = planetService.findOne(id);

        if(planet.isPresent()) {
            return new ResponseEntity<>(toPlanetDto.convert(planet.get()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlanetDTO> create(@Valid @RequestBody PlanetDTO dto){
        Planet planet = toPlanet.convert(dto);
        Planet saved = planetService.save(planet);
        return new ResponseEntity<>(toPlanetDto.convert(saved), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlanetDTO> update(@PathVariable Long id, @Valid @RequestBody PlanetDTO dto){

        if(!id.equals(dto.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Planet planet = toPlanet.convert(dto);
        Planet saved = planetService.update(planet);
        return new ResponseEntity<>(toPlanetDto.convert(saved),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Planet deleted = planetService.delete(id);

        if(deleted != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
