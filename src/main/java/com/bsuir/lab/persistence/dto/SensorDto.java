package com.bsuir.lab.persistence.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorDto {

    private String name;
    private Double xCoordinate;
    private Double yCoordinate;
    private String RegionName;

}
