package com.mi.planets;

import com.mi.planets.model.Planet;
import com.mi.planets.model.Satellite;
import com.mi.planets.repository.PlanetRepository;
import com.mi.planets.service.implementation.JpaPlanetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatObject;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JpaPlanetServiceTest {

    @Mock
    private PlanetRepository mockPlanetRepository;

    private JpaPlanetService jpaPlanetServiceUnderTest;

    @BeforeEach
    void setUp() {
        jpaPlanetServiceUnderTest = new JpaPlanetService(mockPlanetRepository);
    }

    @Test
    void testFindOne() {

        final Optional<Planet> planet = Optional.of(new Planet(1L, "TEST_PLANET", 2L, 3L, 4L, 5, null));
        when(mockPlanetRepository.findById(1L)).thenReturn(planet);

        final Optional<Planet> result = jpaPlanetServiceUnderTest.findOne(1L);

        assertThatObject(result).isInstanceOf(Optional.class);
    }


    @Test
    void testSave() {

        final Planet planet1 = new Planet(1L, "TEST_PLANET", 2L, 3L, 4L, 5, List.of(new Satellite(1L, "TEST_SATELLITE", 2L, 3L, false, null)));
        when(mockPlanetRepository.save(any(Planet.class))).thenReturn(planet1);

        final Planet result = jpaPlanetServiceUnderTest.save(planet1);

        assertThatObject(result).isInstanceOf(Planet.class);
    }



    @Test
    void testFindOneById() {
        final Planet planet = new Planet(1L, "TEST_PLANET", 2L, 3L, 4L, 5, List.of(new Satellite(1L, "TEST_SATELLITE", 2L, 3L, false, null)));
        when(mockPlanetRepository.findOneById(1L)).thenReturn(planet);

        final Planet result = jpaPlanetServiceUnderTest.findOneById(1L);

        assertThatObject(result).isInstanceOf(Planet.class);
    }

    @Test
    void testDelete() {

        final Planet planet = new Planet(1L, "TEST_PLANET", 2L, 3L, 4L, 5, List.of(new Satellite(1L, "TEST_SATELLITE", 2L, 3L, false, null)));
        when(mockPlanetRepository.findOneById(1L)).thenReturn(planet);

        final Planet result = jpaPlanetServiceUnderTest.delete(1L);

        verify(mockPlanetRepository).deleteById(1L);
        assertThatObject(result).isInstanceOf(Planet.class);
    }

}
