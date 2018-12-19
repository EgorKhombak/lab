package com.bsuir.lab.services;

import com.bsuir.lab.persistence.dto.SensorDto;
import com.bsuir.lab.persistence.entity.Region;
import com.bsuir.lab.persistence.entity.Sensor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public interface SensorService {

    Sensor create(SensorDto sensorDto);
    Sensor findById(Long id);
    void deleteById(Long id);
    Sensor update(JsonNode jsonNode) throws JsonProcessingException, IllegalAccessException;
    List<Sensor> getAllSensors();
    Sensor findByName(String name);
}
