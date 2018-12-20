package com.bsuir.lab.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Date;

@Entity
@Table(name = "dataregister")
public class DataRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sensorId")
    private Sensor sensor;

    @Column(name = "dataregisterdate")
    private Date date;

    @Column(name = "dataregistertime")
    private Time time;

    private Double temperature;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
}
