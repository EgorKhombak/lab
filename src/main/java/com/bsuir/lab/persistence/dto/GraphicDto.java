package com.bsuir.lab.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GraphicDto {

    private String  regionName;
    private Set<String> dataRegisterDate;
    private Set<SensorDtoForGraphic> sensorDtos;
}
