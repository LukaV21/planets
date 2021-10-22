package com.mi.planets.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@SQLDelete(sql = "UPDATE planet SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Planet {

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
    @Column(nullable = false)
    private Long distanceFromSun;
    @Column
    private int averageSurfaceTemperature;
    @OneToMany(mappedBy = "planet", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Satellite> satellites = new ArrayList<>();
    @Column
    private Boolean deleted = Boolean.FALSE;


    public Planet() {
    }

    public Planet(Long id, String name, Long surfaceArea, Long mass, Long distanceFromSun, int averageSurfaceTemperature, List<Satellite> satellites) {
        this.id = id;
        this.name = name;
        this.surfaceArea = surfaceArea;
        this.mass = mass;
        this.distanceFromSun = distanceFromSun;
        this.averageSurfaceTemperature = averageSurfaceTemperature;
        this.satellites = satellites;
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

    public Long getDistanceFromSun() {
        return distanceFromSun;
    }

    public void setDistanceFromSun(Long distanceFromSun) {
        this.distanceFromSun = distanceFromSun;
    }

    public int getAverageSurfaceTemperature() {
        return averageSurfaceTemperature;
    }

    public void setAverageSurfaceTemperature(int averageSurfaceTemperature) {
        this.averageSurfaceTemperature = averageSurfaceTemperature;
    }

    public List<Satellite> getSatellites() {
        return satellites;
    }

    public void setSatellites(List<Satellite> satellites) {
        this.satellites = satellites;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
