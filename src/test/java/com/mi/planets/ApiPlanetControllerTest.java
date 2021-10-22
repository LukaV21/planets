package com.mi.planets;

import com.mi.planets.model.Planet;
import com.mi.planets.service.PlanetService;
import com.mi.planets.support.planet.PlanetDtoToPlanet;
import com.mi.planets.support.planet.PlanetToPlanetDto;
import com.mi.planets.support.satellite.SatelliteDtoToSatellite;
import com.mi.planets.web.controller.ApiPlanetController;
import com.mi.planets.web.dto.PlanetDTO;
import com.mi.planets.web.dto.SatelliteDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ApiPlanetController.class)
class ApiPlanetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlanetService mockPlanetService;
    @MockBean
    private PlanetToPlanetDto mockToPlanetDto;
    @MockBean
    private PlanetDtoToPlanet mockToPlanet;
    @MockBean
    private SatelliteDtoToSatellite toSatellite;

    @Test
    void testGetAllPlanets() throws Exception {

        Planet planet = new Planet();
        planet.setId(1L);
        planet.setName("TEST_PLANET");
        planet.setSurfaceArea(55L);
        planet.setMass(44L);
        planet.setDistanceFromSun(33L);
        planet.setAverageSurfaceTemperature(23);
        final Page<Planet> planets = new PageImpl<>(List.of(planet));
        when(mockPlanetService.findAllFiltered("TEST_PLANET", 0, 1)).thenReturn(planets);

        final PlanetDTO planetDTO = new PlanetDTO();
        planetDTO.setId(planet.getId());
        planetDTO.setName(planet.getName());
        planetDTO.setSurfaceArea(planet.getSurfaceArea());
        planetDTO.setMass(planet.getMass());
        planetDTO.setDistanceFromSun(planet.getDistanceFromSun());
        planetDTO.setAverageSurfaceTemperature(planet.getAverageSurfaceTemperature());
        planetDTO.setSatellites(Collections.emptyList());
        final List<PlanetDTO> planetDTOS = List.of(planetDTO);
        when(mockToPlanetDto.convert(List.of(planet))).thenReturn(planetDTOS);

        final MockHttpServletResponse response = mockMvc.perform(get("/api/planets")
                .param("name", "TEST_PLANET")
                .param("page", "0")
                .param("size", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentType()).isEqualTo("application/json");

    }



    @Test
    void testGet() throws Exception {

        Planet planet = new Planet();
        planet.setId(1L);
        planet.setName("TEST_PLANET");
        planet.setSurfaceArea(55L);
        planet.setMass(44L);
        planet.setDistanceFromSun(33L);
        planet.setAverageSurfaceTemperature(23);
        final Optional<Planet> planetOptional = Optional.of(planet);
        when(mockPlanetService.findOne(1L)).thenReturn(planetOptional);

        final PlanetDTO planetDTO = new PlanetDTO();
        planetDTO.setId(planet.getId());
        planetDTO.setName(planet.getName());
        planetDTO.setSurfaceArea(planet.getSurfaceArea());
        planetDTO.setMass(planet.getMass());
        planetDTO.setDistanceFromSun(planet.getDistanceFromSun());
        planetDTO.setAverageSurfaceTemperature(planet.getAverageSurfaceTemperature());
        final SatelliteDTO satelliteDTO = new SatelliteDTO();
        satelliteDTO.setId(0L);
        satelliteDTO.setName("TEST_SATELLITE");
        satelliteDTO.setSurfaceArea(0L);
        satelliteDTO.setMass(0L);
        satelliteDTO.setNaturalSatellite(false);
        satelliteDTO.setPlanetId(0L);
        satelliteDTO.setPlanetName("TEST_PLANET");
        planetDTO.setSatellites(List.of(satelliteDTO));
        when(mockToPlanetDto.convert(any(Planet.class))).thenReturn(planetDTO);

        final MockHttpServletResponse response = mockMvc.perform(get("/api/planets/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentType()).isEqualTo("application/json");
    }



}

