package com.mi.planets.repository;

import com.mi.planets.model.Planet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {
    Page<Planet> findAllByNameIgnoreCaseContains(String name, Pageable pageable);

    Planet findOneById(Long id);

    @Query("SELECT p FROM Planet p LEFT JOIN Satellite s ON p.id = s.planet.id GROUP BY p.id ORDER BY COUNT(s.id) DESC, p.id ASC")
    Page<Planet> findAllSorted(Pageable pageable);
}
