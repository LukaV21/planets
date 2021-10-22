package com.mi.planets.web.dto;

import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

public class PlanetDTO {
    @Positive(message = "ID must be a positive number.")
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    @Positive
    @NotNull
    private Long surfaceArea;
    @Positive
    @NotNull
    private Long mass;
    @Positive
    @NotNull
    private Long distanceFromSun;

    private Integer averageSurfaceTemperature;
    private List<SatelliteDTO> satellites = new ArrayList<>();




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

    public Long getDistanceFromSun() {
        return distanceFromSun;
    }

    public void setDistanceFromSun(Long distanceFromSun) {
        this.distanceFromSun = distanceFromSun;
    }

    public Integer getAverageSurfaceTemperature() {
        return averageSurfaceTemperature;
    }

    public void setAverageSurfaceTemperature(Integer averageSurfaceTemperature) {
        this.averageSurfaceTemperature = averageSurfaceTemperature;
    }

    public List<SatelliteDTO> getSatellites() {
        return satellites;
    }

    public void setSatellites(List<SatelliteDTO> satellites) {
        this.satellites = satellites;
    }
}
