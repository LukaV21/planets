package com.mi.planets.model;

import javax.persistence.*;

@Entity
public class Satellite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Long surfaceArea;
    @Column(nullable = false)
    private Long mass;
    @Column
    private Boolean naturalSatellite;
    @ManyToOne
    private Planet planet;

    public Satellite() {
    }

    public Satellite(Long id, String name, Long surfaceArea, Long mass, Boolean naturalSatellite, Planet planet) {
        this.id = id;
        this.name = name;
        this.surfaceArea = surfaceArea;
        this.mass = mass;
        this.naturalSatellite = naturalSatellite;
        this.planet = planet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(Long surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public Long getMass() {
        return mass;
    }

    public void setMass(Long mass) {
        this.mass = mass;
    }

    public Boolean getNaturalSatellite() {
        return naturalSatellite;
    }

    public void setNaturalSatellite(Boolean naturalSatellite) {
        this.naturalSatellite = naturalSatellite;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }
}

