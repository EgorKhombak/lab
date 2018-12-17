package com.bsuir.lab.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllInformDto {

    private String regionName;
    private String sensorName;
    private Double xCoordinate;
    private Double yCoordinate;
    private Date dataRegisterDate;
    private Date dataRegisterTime;
    private Double temperature;
}
