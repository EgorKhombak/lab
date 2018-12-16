package com.bsuir.lab.services;

import com.bsuir.lab.persistence.entity.DataRegister;
import com.bsuir.lab.persistence.entity.Region;

import java.util.List;

public interface DataRegisterService {

    DataRegister create(DataRegister dataRegister);
    DataRegister findById(Long id);
    void deleteById(Long id);
    DataRegister update(DataRegister dataRegister);
    List<DataRegister> getAllDataRegisters();
}
