package com.bsuir.lab.dao;

import com.bsuir.lab.persistence.entity.DataRegister;

import java.util.List;

public interface DataRegisterDao {

    DataRegister create(DataRegister dataRegister);
    DataRegister findBuId(Long id);
    void deleteById(Long id);
    DataRegister update(DataRegister dataRegister);
    List<DataRegister> getAllDataRegisters();
}
