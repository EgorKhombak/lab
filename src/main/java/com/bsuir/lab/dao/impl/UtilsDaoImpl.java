package com.bsuir.lab.dao.impl;

import com.bsuir.lab.dao.DataRegisterDao;
import com.bsuir.lab.dao.RegionDao;
import com.bsuir.lab.dao.SensorDao;
import com.bsuir.lab.dao.UtilsDao;
import com.bsuir.lab.persistence.dto.DataRegisterDtoForGraphic;
import com.bsuir.lab.persistence.dto.GraphicDto;
import com.bsuir.lab.persistence.dto.SensorDtoForGraphic;
import com.bsuir.lab.persistence.entity.DataRegister;
import com.bsuir.lab.persistence.entity.Region;
import com.bsuir.lab.persistence.entity.Sensor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UtilsDaoImpl implements UtilsDao {

    private EntityManager entityManager;
    private ObjectMapper objectMapper;
    private RegionDao regionDao;
    private SensorDao sensorDao;
    private DataRegisterDao dataRegisterDao;

    @Inject
    public UtilsDaoImpl(EntityManager entityManager, ObjectMapper objectMapper, RegionDao regionDao,
                        SensorDao sensorDao, DataRegisterDao dataRegisterDao) {
        this.entityManager = entityManager;
        this.objectMapper = objectMapper;
        this.regionDao = regionDao;
        this.sensorDao = sensorDao;
        this.dataRegisterDao = dataRegisterDao;
    }

    @Override
    public List<Object[]> getAllInfo() {
        List<Object[]> objects = entityManager.createQuery("" +
                "select r.name, s.name, s.xCoordinate, s.yCoordinate, s.region.id, dr " +
                "from Region r " +
                "left outer join Sensor s on r.id = s.region.id " +
                "left outer join DataRegister dr on s.id = dr.sensor.id", Object[].class).getResultList();
        return objects;
    }

    @Override
    public List<GraphicDto> getAllForGraphic() {

        Set<String> dataRegisterDates = new HashSet<>();
        List<GraphicDto> graphicDtos = new ArrayList<>();
        List<Region> regions = regionDao.getAllRegions();

        for (Region region: regions) {
            Set<SensorDtoForGraphic> sensorDtoForGraphics = new HashSet<>();

            Query sensorQuery = entityManager.createQuery("" +
                    "select s from Sensor s where s.region.id = :regionId", Sensor.class);
            sensorQuery.setParameter("regionId", region.getId());
            List<Sensor> sensors = sensorQuery.getResultList();

            for (Sensor sensor: sensors) {
                Set<DataRegisterDtoForGraphic> dataRegisterDtoForGraphicsSet = new HashSet<>();

                Query dataRegisterQuery = entityManager.createQuery("" +
                        "select dr from DataRegister dr where dr.sensor.id = :sensorId", DataRegister.class);
                dataRegisterQuery.setParameter("sensorId", sensor.getId());
                List<DataRegister> dataRegisters = dataRegisterQuery.getResultList();

                dataRegisters.forEach(d -> {
                    dataRegisterDtoForGraphicsSet.add(new DataRegisterDtoForGraphic(d.getTemperature(), String.valueOf(d.getDate())));
                    dataRegisterDates.add(String.valueOf(d.getDate()));
                });

                sensorDtoForGraphics.add(new SensorDtoForGraphic(sensor.getName(), dataRegisterDtoForGraphicsSet));
            }
            graphicDtos.add(new GraphicDto(region.getName(), dataRegisterDates, sensorDtoForGraphics));
        }
        return graphicDtos;
    }
}
