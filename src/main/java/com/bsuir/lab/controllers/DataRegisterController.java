package com.bsuir.lab.controllers;

import com.bsuir.lab.config.FilterChainClass;
import com.bsuir.lab.mappers.DataRegisterMapper;
import com.bsuir.lab.persistence.dto.DataRegisterDto;
import com.bsuir.lab.persistence.entity.DataRegister;
import com.bsuir.lab.services.DataRegisterService;
import com.bsuir.lab.services.SensorService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.FilterChain;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/dataRegisters")
public class DataRegisterController {

    private DataRegisterMapper dataRegisterMapper;
    private DataRegisterService dataRegisterService;
    private SensorService sensorService;

    @Inject
    public DataRegisterController(DataRegisterMapper dataRegisterMapper,
                                  DataRegisterService dataRegisterService,
                                  SensorService sensorService) {
        this.dataRegisterMapper = dataRegisterMapper;
        this.dataRegisterService = dataRegisterService;
        this.sensorService = sensorService;
    }

    @ResponseBody
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataRegister> getAllRegion(){
        return dataRegisterService.getAllDataRegisters();
    }

    @ResponseBody
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public DataRegisterDto createDataRegister(@RequestBody DataRegisterDto dataRegisterDto) {
        dataRegisterService.create(dataRegisterDto);
        return dataRegisterDto;
    }

    @ResponseBody
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DataRegister getRegionById(@PathVariable Long id) {
        return dataRegisterService.findById(id);
    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public void deleteDataRegisterById(@PathVariable Long id) {
        dataRegisterService.deleteById(id);
    }

    @ResponseBody
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonNode updateRegion(@RequestBody JsonNode jsonNode) throws IOException, IllegalAccessException {

        dataRegisterService.update(jsonNode);
        return jsonNode;
    }
}
