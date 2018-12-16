package com.bsuir.lab.persistence.dto;

import lombok.Data;

@Data
public class AllInformDto {

    private String sensorName;
    private String regionNmae;
    private String dataRegisterDate;
    private String dataRegisterTime;
    private Double temperature;
    private Double xCoordinate;
    private Double yCoordinate;

}
