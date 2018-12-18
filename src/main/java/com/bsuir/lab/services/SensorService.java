package com.bsuir.lab.services;

import com.bsuir.lab.persistence.dto.SensorDto;
import com.bsuir.lab.persistence.entity.Region;
import com.bsuir.lab.persistence.entity.Sensor;

import java.util.List;

public interface SensorService {

    Sensor create(SensorDto sensorDto);
    Sensor findById(Long id);
    void deleteById(Long id);
    Sensor update(Sensor sensor);
    List<Sensor> getAllSensors();
}
