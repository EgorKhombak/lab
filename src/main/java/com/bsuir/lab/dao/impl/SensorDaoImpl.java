package com.bsuir.lab.dao.impl;

import com.bsuir.lab.dao.SensorDao;
import com.bsuir.lab.persistence.entity.Sensor;
import com.bsuir.lab.utils.Querys;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
public class SensorDaoImpl implements SensorDao {

    private final EntityManager entityManager;

    @Inject
    public SensorDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Sensor create(Sensor sensor) {
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
}
