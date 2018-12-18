package com.bsuir.lab.dao.impl;

import com.bsuir.lab.dao.RegionDao;
import com.bsuir.lab.dao.SensorDao;
import com.bsuir.lab.persistence.dto.SensorDto;
import com.bsuir.lab.persistence.entity.Region;
import com.bsuir.lab.persistence.entity.Sensor;
import com.bsuir.lab.utils.Querys;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
public class SensorDaoImpl implements SensorDao {

    private final EntityManager entityManager;
    private RegionDao regionDao;

    @Inject
    public SensorDaoImpl(EntityManager entityManager, RegionDao regionDao) {
        this.entityManager = entityManager;
        this.regionDao = regionDao;
    }

    @Override
    public Sensor create(SensorDto sensorDto) {
        Region region = regionDao.findByName(sensorDto.getRegionName());
        Sensor sensor = new Sensor();

        sensor.setName(sensorDto.getName());
        sensor.setRegion(region);
        sensor.setxCoordinate(sensorDto.getXCoordinate());
        sensor.setyCoordinate(sensorDto.getYCoordinate());

        entityManager.persist(sensor);
        return sensor;
    }

    @Override
    public Sensor findBuId(Long id) {
        return entityManager.find(Sensor.class, id);
    }

    @Override
    public void deleteById(Long id) {
        Sensor sensor= entityManager.getReference(Sensor.class, id);
        entityManager.remove(sensor);
    }

    @Override
    public Sensor update(Sensor sensor) {
        entityManager.merge(sensor);
        return sensor;
    }

    @Override
    public List<Sensor> getAllSensors() {
        return entityManager.createQuery(Querys.GET_ALL_SENSORS.getQuery(), Sensor.class).getResultList();
    }

    @Override
    public Sensor findSensorByName(String name) {
        Query query = entityManager.createQuery(Querys.GET_SENSOR_BY_NAME.getQuery(), Sensor.class);
        query.setParameter("name", name);
        return (Sensor) query.getSingleResult();
    }
}
