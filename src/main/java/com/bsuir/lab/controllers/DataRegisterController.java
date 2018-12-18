package com.bsuir.lab.controllers;

import com.bsuir.lab.config.FilterChainClass;
import com.bsuir.lab.mappers.DataRegisterMapper;
import com.bsuir.lab.persistence.dto.DataRegisterDto;
import com.bsuir.lab.persistence.entity.DataRegister;
import com.bsuir.lab.services.DataRegisterService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.FilterChain;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/dataRegister")
public class DataRegisterController {

    private DataRegisterMapper dataRegisterMapper;
    private DataRegisterService dataRegisterService;

    @Inject
    public DataRegisterController(DataRegisterMapper dataRegisterMapper,
                                  DataRegisterService dataRegisterService) {
        this.dataRegisterMapper = dataRegisterMapper;
        this.dataRegisterService = dataRegisterService;
    }

    @ResponseBody
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataRegisterDto> getAllRegion(){
        return dataRegisterService.getAllDataRegisters().stream()
                .map(dataRegisterMapper::toDto)
                .collect(Collectors.toList());
    }

    @ResponseBody
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public DataRegisterDto createDataRegister(@RequestBody DataRegisterDto dataRegisterDto) {
        dataRegisterService.create(dataRegisterDto);
        return dataRegisterDto;
    }

    @ResponseBody
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DataRegisterDto getRegionById(@PathVariable Long id) {
        return dataRegisterMapper.toDto(dataRegisterService.findById(id));
    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public void deleteDataRegisterById(@PathVariable Long id) {
        dataRegisterService.deleteById(id);
    }

    @ResponseBody
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public DataRegisterDto updateRegion(@RequestBody DataRegister dataRegister) {
        dataRegisterService.update(dataRegister);
        return dataRegisterMapper.toDto(dataRegister);
    }
}
