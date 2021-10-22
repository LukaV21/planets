package com.mi.planets.web.dto;

import com.sun.istack.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class SatelliteDTO {
    @Positive(message = "ID must be a positive number.")
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    @Positive(message = "Surface Area is required")
    @NotNull
    private Long surfaceArea;
    @Positive(message = "Mass is required")
    @NotNull
    private Long mass;
    @Nullable
    private Boolean naturalSatellite;

    private Long planetId;
    private String planetName;

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

    public Long getPlanetId() {
        return planetId;
    }

    public void setPlanetId(Long planetId) {
        this.planetId = planetId;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }
}
