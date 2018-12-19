package com.bsuir.lab.services.impl;

import com.bsuir.lab.dao.DataRegisterDao;
import com.bsuir.lab.dao.SensorDao;
import com.bsuir.lab.persistence.dto.DataRegisterDto;
import com.bsuir.lab.persistence.entity.DataRegister;
import com.bsuir.lab.persistence.entity.Sensor;
import com.bsuir.lab.services.DataRegisterService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class DataRegisterServiceImpl implements DataRegisterService {

    private DataRegisterDao dataRegisterDao;
    private SensorDao sensorDao;
    private ObjectMapper mapper;

    @Inject
    public DataRegisterServiceImpl(DataRegisterDao dataRegisterDao, SensorDao sensorDao, ObjectMapper mapper) {
        this.dataRegisterDao = dataRegisterDao;
        this.sensorDao = sensorDao;
        this.mapper = mapper;
    }

    @Override
    public DataRegister create(DataRegisterDto dataRegisterDto) {
        return dataRegisterDao.create(dataRegisterDto);
    }

    @Override
    public DataRegister findById(Long id) {
        return dataRegisterDao.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        dataRegisterDao.deleteById(id);
    }

    @Override
    public DataRegister update(JsonNode jsonNode) throws IllegalAccessException, IOException {
        if (jsonNode.get("id") != null && !jsonNode.get("id").asText().isEmpty()) {
            DataRegister dataRegister = dataRegisterDao.findById(jsonNode.get("id").asLong());

            if (dataRegister != null) {
                DataRegister update = mapper.treeToValue(jsonNode, DataRegister.class);

                if (jsonNode.get("sensorName") != null && !jsonNode.get("sensorName").asText().isEmpty() &&
                        jsonNode.get("sensorName").asText().equals(dataRegister.getSensor().getName())) {

                    update.setSensor(dataRegister.getSensor());
                    return dataRegisterDao.update(update);
                }

                else {

                    Sensor sensor = sensorDao.findSensorByName(jsonNode.get("sensorName").asText());
                    update.setSensor(sensor);
                    return dataRegisterDao.update(update);
                }
            }
            else throw new IllegalAccessException("Не найден DataRegister c id: " + jsonNode.get("id").asLong());
        }
        else throw new IllegalAccessException("Не найден id");
    }

    @Override
    public List<DataRegister> getAllDataRegisters() {
        return dataRegisterDao.getAllDataRegisters();
    }
}
