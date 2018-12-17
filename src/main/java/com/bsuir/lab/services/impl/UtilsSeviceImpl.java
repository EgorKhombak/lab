package com.bsuir.lab.services.impl;

import com.bsuir.lab.dao.DataRegisterDao;
import com.bsuir.lab.dao.RegionDao;
import com.bsuir.lab.dao.SensorDao;
import com.bsuir.lab.dao.UtilsDao;
import com.bsuir.lab.persistence.dto.AllInformDto;
import com.bsuir.lab.persistence.dto.GraphicDto;
import com.bsuir.lab.services.UtilsSevice;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

@Service
public class UtilsSeviceImpl implements UtilsSevice {

    private UtilsDao utilsDao;
    private ObjectMapper objectMapper;
    private SensorDao sensorDao;
    private RegionDao regionDao;
    private DataRegisterDao dataRegisterDao;

    @Inject
    public UtilsSeviceImpl(UtilsDao utilsDao, ObjectMapper objectMapper, SensorDao sensorDao,
                           RegionDao regionDao, DataRegisterDao dataRegisterDao) {
        this.utilsDao = utilsDao;
        this.objectMapper = objectMapper;
        this.sensorDao = sensorDao;
        this.regionDao = regionDao;
        this.dataRegisterDao = dataRegisterDao;
    }

    @Override
    public List<AllInformDto> getAllInfo() throws IOException, JSONException {
        return utilsDao.getAllInfo();
    }

    @Override
    public List<GraphicDto> getAllForGraphic(List<String> regionNames) throws IOException {
        return utilsDao.getAllForGraphic(regionNames);
    }
}
