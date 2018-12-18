package com.bsuir.lab.services.impl;

import com.bsuir.lab.dao.DataRegisterDao;
import com.bsuir.lab.persistence.dto.DataRegisterDto;
import com.bsuir.lab.persistence.entity.DataRegister;
import com.bsuir.lab.services.DataRegisterService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DataRegisterServiceImpl implements DataRegisterService {

    private DataRegisterDao dataRegisterDao;

    @Inject
    public DataRegisterServiceImpl(DataRegisterDao dataRegisterDao) {
        this.dataRegisterDao = dataRegisterDao;
    }

    @Override
    public DataRegister create(DataRegisterDto dataRegisterDto) {
        return dataRegisterDao.create(dataRegisterDto);
    }

    @Override
    public DataRegister findById(Long id) {
        return dataRegisterDao.findBuId(id);
    }

    @Override
    public void deleteById(Long id) {
        dataRegisterDao.deleteById(id);
    }

    @Override
    public DataRegister update(DataRegister dataRegister) {
        return dataRegisterDao.update(dataRegister);
    }

    @Override
    public List<DataRegister> getAllDataRegisters() {
        return dataRegisterDao.getAllDataRegisters();
    }
}
