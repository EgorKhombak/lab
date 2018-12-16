package com.bsuir.lab.controllers;

import com.bsuir.lab.config.JwtFilter;
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

    private JwtFilter jwtFilter = new JwtFilter();

    @Inject
    public SensorController(SensorMapper sensorMapper, SensorService sensorService) {
        this.sensorMapper = sensorMapper;
        this.sensorService = sensorService;
    }

    @ResponseBody
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SensorDto> getAllSensors(ServletRequest request,
                                         ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        jwtFilter.doFilter(request, response, filterChain);
        return sensorService.getAllSensors().stream()
                .map(sensorMapper::toSensorDto)
                .collect(Collectors.toList());
    }

    @ResponseBody
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SensorDto getSensorById(@PathVariable Long id, ServletRequest request,
                                   ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        jwtFilter.doFilter(request, response, filterChain);
        return sensorMapper.toSensorDto(sensorService.findById(id));


    }

    @ResponseBody
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public SensorDto createSensor(@RequestBody  Sensor sensor, ServletRequest request,
                                  ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        jwtFilter.doFilter(request, response, filterChain);
        sensorService.create(sensor);
        return sensorMapper.toSensorDto(sensor);
    }


    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public void deleteSensorById(@PathVariable Long id, ServletRequest request,
                                 ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        jwtFilter.doFilter(request, response, filterChain);
        sensorService.deleteById(id);
    }

    @ResponseBody
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public SensorDto updateSensor(@RequestBody Sensor sensor, ServletRequest request,
                                  ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        jwtFilter.doFilter(request, response, filterChain);
        sensorService.update(sensor);
        return sensorMapper.toSensorDto(sensor);
    }
}
