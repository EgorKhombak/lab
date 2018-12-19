package com.bsuir.lab.controllers;

import com.bsuir.lab.config.JwtFilter;
import com.bsuir.lab.mappers.SensorMapper;
import com.bsuir.lab.persistence.dto.RegionDto;
import com.bsuir.lab.persistence.dto.SensorDto;
import com.bsuir.lab.persistence.entity.Region;
import com.bsuir.lab.persistence.entity.Sensor;
import com.bsuir.lab.services.SensorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
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
    public List<Sensor> getAllSensors() {
        return sensorService.getAllSensors();
    }

    @ResponseBody
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Sensor getSensorById(@PathVariable Long id) {
        return sensorService.findById(id);
    }

    @ResponseBody
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public SensorDto createSensor(@RequestBody  SensorDto sensorDto) {
        sensorService.create(sensorDto);
        return sensorDto;
    }


    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public void deleteSensorById(@PathVariable Long id) {
        sensorService.deleteById(id);
    }

    @ResponseBody
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonNode updateSensor(@RequestBody JsonNode jsonNode) throws JsonProcessingException, IllegalAccessException {
        sensorService.update(jsonNode);
        return jsonNode;
    }
}
