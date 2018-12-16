package com.bsuir.lab.controllers;

import com.bsuir.lab.mappers.SensorMapper;
import com.bsuir.lab.persistence.dto.RegionDto;
import com.bsuir.lab.persistence.dto.SensorDto;
import com.bsuir.lab.persistence.entity.Region;
import com.bsuir.lab.persistence.entity.Sensor;
import com.bsuir.lab.services.SensorService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/sensors")
public class SensorController {

    private SensorMapper sensorMapper;
    private SensorService sensorService;

    @Inject
    public SensorController(SensorMapper sensorMapper, SensorService sensorService) {
        this.sensorMapper = sensorMapper;
        this.sensorService = sensorService;
    }

    @ResponseBody
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SensorDto> getAllSensors() {
        return sensorService.getAllSensors().stream()
                .map(sensorMapper::toSensorDto)
                .collect(Collectors.toList());
    }

    @ResponseBody
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SensorDto getSensorById(@PathVariable Long id) {
        return sensorMapper.toSensorDto(sensorService.findById(id));


    }

    @ResponseBody
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public SensorDto createSensor(@RequestBody  Sensor sensor) {
        sensorService.create(sensor);
        return sensorMapper.toSensorDto(sensor);
    }


    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public void deleteSensorById(@PathVariable Long id) {
        sensorService.deleteById(id);
    }

    @ResponseBody
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public SensorDto updateSensor(@RequestBody Sensor sensor) {
        sensorService.update(sensor);
        return sensorMapper.toSensorDto(sensor);
    }
}
