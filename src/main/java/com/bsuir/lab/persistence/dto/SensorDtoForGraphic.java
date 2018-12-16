package com.bsuir.lab.persistence.dto;

import com.bsuir.lab.persistence.entity.DataRegister;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorDtoForGraphic {

    private String sensorName;
    private Set<DataRegisterDtoForGraphic> dataRegisters;
}
