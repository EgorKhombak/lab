package com.bsuir.lab.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "regions")
public class Region{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "region")
    private Set<Sensor> sensors;

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

    public Set<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(Set<Sensor> sensors) {
        this.sensors = sensors;
    }
}
