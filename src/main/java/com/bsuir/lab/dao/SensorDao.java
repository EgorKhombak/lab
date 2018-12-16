package com.bsuir.lab.dao;

import com.bsuir.lab.persistence.entity.Sensor;

import java.util.List;

public interface SensorDao {

    Sensor create(Sensor sensor);
    Sensor findBuId(Long id);
    void deleteById(Long id);
    Sensor update(Sensor sensor);
    List<Sensor> getAllSensors();
}
