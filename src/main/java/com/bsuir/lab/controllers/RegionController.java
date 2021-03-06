package com.bsuir.lab.controllers;

import com.bsuir.lab.config.JwtFilter;
import com.bsuir.lab.mappers.RegionMapper;
import com.bsuir.lab.persistence.dto.RegionDto;
import com.bsuir.lab.persistence.entity.Region;
import com.bsuir.lab.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/regions")
public class RegionController {

    private RegionService regionService;
    private RegionMapper regionMapper;

    @Autowired
    public RegionController(RegionService regionService, RegionMapper regionMapper) {
        this.regionService = regionService;
        this.regionMapper = regionMapper;
    }

    @ResponseBody
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Region> getAllDataRegisters()  {
        return regionService.getAllRegions();
    }

    @ResponseBody
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public RegionDto createDataRegister(@RequestBody Region region) {
        regionService.create(region);
        return regionMapper.toRegionDto(region);
    }

    @ResponseBody
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RegionDto getRegionById(@PathVariable Long id) {
        return regionMapper.toRegionDto(regionService.findById(id));
    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public void deleteRegionById(@PathVariable Long id) {
        regionService.deleteById(id);
    }

    @ResponseBody
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public RegionDto updateRegion(@RequestBody Region region) {
        regionService.update(region);
        return regionMapper.toRegionDto(region);
    }
}
