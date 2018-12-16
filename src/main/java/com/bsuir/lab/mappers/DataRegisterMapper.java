package com.bsuir.lab.mappers;

import com.bsuir.lab.dao.DataRegisterDao;
import com.bsuir.lab.persistence.dto.DataRegisterDto;
import com.bsuir.lab.persistence.entity.DataRegister;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class DataRegisterMapper {

    public DataRegisterDto toDto(DataRegister dataRegister) {
        DataRegisterDto dataRegisterDto = new DataRegisterDto();

        dataRegisterDto.setDate(String.valueOf(dataRegister.getDate()).substring(0, String.valueOf(dataRegister.getDate()).indexOf(" ")));
        dataRegisterDto.setTime(dataRegister.getTime());
        dataRegisterDto.setSensorName(dataRegister.getSensor().getName());
        dataRegisterDto.setTemperature(dataRegister.getTemperature());

        return dataRegisterDto;
    }
}