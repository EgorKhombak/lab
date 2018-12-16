package com.bsuir.lab.persistence.dto;

import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
public class DataRegisterDto {

    private String date;
    private Time time;
    private Double temperature;
    private String sensorName;
}
