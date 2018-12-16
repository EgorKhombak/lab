package com.bsuir.lab.services.impl;

import com.bsuir.lab.dao.SensorDao;
import com.bsuir.lab.persistence.entity.Sensor;
import com.bsuir.lab.services.SensorService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {

    private SensorDao sensorDao;

    @Inject
    public SensorServiceImpl(SensorDao sensorDao) {
        this.sensorDao = sensorDao;
    }

    @Override
    public Sensor create(Sensor sensor) {
        return sensorDao.create(sensor);
    }

    @Override
    public Sensor findById(Long id) {
        return sensorDao.findBuId(id);
    }

    @Override
    public void deleteById(Long id) {
        sensorDao.deleteById(id);
    }

    @Override
    public Sensor update(Sensor sensor) {
        return sensorDao.update(sensor);
    }

    @Override
    public List<Sensor> getAllSensors() {
        return sensorDao.getAllSensors();
    }
}
