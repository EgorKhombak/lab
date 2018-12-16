package com.bsuir.lab.controllers;

import com.bsuir.lab.config.JwtFilter;
import com.bsuir.lab.mappers.DataRegisterMapper;
import com.bsuir.lab.persistence.dto.DataRegisterDto;
import com.bsuir.lab.persistence.dto.RegionDto;
import com.bsuir.lab.persistence.entity.DataRegister;
import com.bsuir.lab.persistence.entity.Region;
import com.bsuir.lab.services.DataRegisterService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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
    public List<DataRegisterDto> getAllRegion(HttpServletRequest httpServletRequest) {
        System.out.println(httpServletRequest.getRequestURL());
        return dataRegisterService.getAllDataRegisters().stream()
                .map(dataRegisterMapper::toDto)
                .collect(Collectors.toList());
    }

    @ResponseBody
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public DataRegisterDto createDataRegister(@RequestBody DataRegister dataRegister, ServletRequest request,
                                              ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        JwtFilter jwtFilter = new JwtFilter();
        jwtFilter.doFilter(request, response, filterChain);
        dataRegisterService.create(dataRegister);
        return dataRegisterMapper.toDto(dataRegister);
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
