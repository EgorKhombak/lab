package com.bsuir.lab.dao;

import com.bsuir.lab.persistence.dto.SensorDto;
import com.bsuir.lab.persistence.entity.Sensor;

import java.util.List;

public interface SensorDao {

    Sensor create(SensorDto sensorDto);
    Sensor findBuId(Long id);
    void deleteById(Long id);
    Sensor update(Sensor sensor);
    List<Sensor> getAllSensors();
    Sensor findSensorByName(String name);
}
