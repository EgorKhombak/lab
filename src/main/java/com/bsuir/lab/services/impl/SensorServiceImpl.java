package com.bsuir.lab.services.impl;

import com.bsuir.lab.dao.RegionDao;
import com.bsuir.lab.dao.SensorDao;
import com.bsuir.lab.persistence.dto.SensorDto;
import com.bsuir.lab.persistence.entity.DataRegister;
import com.bsuir.lab.persistence.entity.Region;
import com.bsuir.lab.persistence.entity.Sensor;
import com.bsuir.lab.services.SensorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SensorServiceImpl implements SensorService {

    private SensorDao sensorDao;
    private ObjectMapper mapper;
    private RegionDao regionDao;

    @Inject
    public SensorServiceImpl(SensorDao sensorDao, ObjectMapper mapper, RegionDao regionDao) {
        this.sensorDao = sensorDao;
        this.mapper = mapper;
        this.regionDao = regionDao;
    }

    @Override
    public Sensor create(SensorDto sensorDto) {
        return sensorDao.create(sensorDto);
    }

    @Override
    public Sensor findById(Long id) {
        return sensorDao.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        sensorDao.deleteById(id);
    }

    @Override
    public Sensor update(JsonNode jsonNode) throws JsonProcessingException, IllegalAccessException {
        if (jsonNode.get("id") != null && !jsonNode.get("id").asText().isEmpty()) {
            Sensor sensor = sensorDao.findById(jsonNode.get("id").asLong());

            if (sensor != null) {
                Sensor update = mapper.treeToValue(jsonNode, Sensor.class);

                if (jsonNode.get("regionName") != null && !jsonNode.get("regionName").asText().isEmpty() &&
                        jsonNode.get("regionName").asText().equals(sensor.getRegion().getName())) {

                    update.setRegion(sensor.getRegion());
                    return sensorDao.update(update);
                }

                else {

                    Region region = regionDao.findByName(jsonNode.get("regionName").asText());
                    update.setRegion(region);
                    return sensorDao.update(update);
                }
            }
            else throw new IllegalAccessException("Не найден DataRegister c id: " + jsonNode.get("id").asLong());
        }
        else throw new IllegalAccessException("Не найден id");
    }

    @Override
    public List<Sensor> getAllSensors() {
        return sensorDao.getAllSensors();
    }

    @Override
    public Sensor findByName(String name) {
        return sensorDao.findSensorByName(name);
    }
}
