package com.bsuir.lab.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GraphicDatesDto {

    private Date date;
    private Double averageTemperature;
}
