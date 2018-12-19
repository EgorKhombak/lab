package com.bsuir.lab.mappers;

import com.bsuir.lab.dao.DataRegisterDao;
import com.bsuir.lab.persistence.dto.DataRegisterDto;
import com.bsuir.lab.persistence.entity.DataRegister;
import com.bsuir.lab.persistence.entity.Sensor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.sql.Date;
import java.sql.Time;

@Mapper(componentModel = "spring")
public class DataRegisterMapper {

    public DataRegisterDto toDto(DataRegister dataRegister) {
        DataRegisterDto dataRegisterDto = new DataRegisterDto();

        dataRegisterDto.setDate(String.valueOf(dataRegister.getDate()));
        dataRegisterDto.setTime(String.valueOf(dataRegister.getTime()));
        dataRegisterDto.setSensorName(dataRegister.getSensor().getName());
        dataRegisterDto.setTemperature(dataRegister.getTemperature());

        return dataRegisterDto;
    }
}
