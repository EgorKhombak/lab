package com.bsuir.lab.mappers;

import com.bsuir.lab.dao.SensorDao;
import com.bsuir.lab.persistence.dto.SensorDto;
import com.bsuir.lab.persistence.entity.Sensor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public class SensorMapper {

    public SensorDto toSensorDto(Sensor sensor) {
        SensorDto sensorDto = new SensorDto();

        sensorDto.setName(sensor.getName());
        sensorDto.setRegionName(sensor.getRegion().getName());
        sensorDto.setXCoordinate(sensor.getxCoordinate());
        sensorDto.setYCoordinate(sensor.getyCoordinate());

        return sensorDto;
    }
}
