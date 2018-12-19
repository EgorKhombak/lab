package com.bsuir.lab.dao.impl;

import com.bsuir.lab.dao.DataRegisterDao;
import com.bsuir.lab.dao.SensorDao;
import com.bsuir.lab.persistence.dto.DataRegisterDto;
import com.bsuir.lab.persistence.dto.SensorDto;
import com.bsuir.lab.persistence.entity.DataRegister;
import com.bsuir.lab.persistence.entity.Sensor;
import com.bsuir.lab.utils.Querys;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Repository
public class DataRegisterDaoImpl implements DataRegisterDao {

    private final EntityManager entityManager;
    private SensorDao sensorDao;

    @Inject
    public DataRegisterDaoImpl(EntityManager entityManager, SensorDao sensorDao) {
        this.entityManager = entityManager;
        this.sensorDao = sensorDao;
    }

    @Override
    public DataRegister create(DataRegisterDto dataRegisterDto) {
        DataRegister dataRegister = new DataRegister();
        Sensor sensor = sensorDao.findSensorByName(dataRegisterDto.getSensorName());

        dataRegister.setDate(Date.valueOf(dataRegisterDto.getDate()));
        dataRegister.setTime(Time.valueOf(dataRegisterDto.getTime()));
        dataRegister.setTemperature(dataRegisterDto.getTemperature());
        dataRegister.setSensor(sensor);

        entityManager.persist(dataRegister);
        return dataRegister;
    }

    @Override
    public DataRegister findById(Long id) {
        return entityManager.find(DataRegister.class, id);
    }

    @Override
    public void deleteById(Long id) {
        DataRegister dataRegister = entityManager.getReference(DataRegister.class, id);
        entityManager.remove(dataRegister);
    }

    @Override
    public DataRegister update(DataRegister dataRegister) {
        entityManager.merge(dataRegister);
        return dataRegister;
    }

    @Override
    public List<DataRegister> getAllDataRegisters() {
        return entityManager.createQuery(Querys.GET_ALL_DATA_REGISTERS.getQuery(), DataRegister.class).getResultList();
    }
}
