package com.bsuir.lab.dao.impl;

import com.bsuir.lab.dao.DataRegisterDao;
import com.bsuir.lab.dao.RegionDao;
import com.bsuir.lab.dao.SensorDao;
import com.bsuir.lab.dao.UtilsDao;
import com.bsuir.lab.persistence.dto.AllInformDto;
import com.bsuir.lab.persistence.dto.GraphicDatesDto;
import com.bsuir.lab.persistence.dto.GraphicDto;
import com.bsuir.lab.persistence.entity.Region;
import com.bsuir.lab.utils.Querys;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Slf4j
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
    public List<AllInformDto> getAllInfo() {
        List<AllInformDto> objects = entityManager.createQuery(Querys.GET_ALL_INFO.getQuery(), AllInformDto.class).getResultList();

        return objects;
    }

    @Override
    public List<GraphicDto> getAllForGraphic() {
        List<Region> regions = regionDao.getAllRegions();
        List<GraphicDto> graphicDtos = new ArrayList<>();

        for (Region region : regions) {
            GraphicDto graphicDto = new GraphicDto();
            graphicDto.setRegionName(region.getName());

            Query query = entityManager.createQuery(Querys.GET_GRAPHIC_DATES_BY_REGION_ID.getQuery(), GraphicDatesDto.class);
            log.info(query.toString());
            query.setParameter("regionId", region.getId());

            List<GraphicDatesDto> graphicDatesDtos = query.getResultList();
            graphicDto.setDates(graphicDatesDtos);

            graphicDtos.add(graphicDto);
        }

        return graphicDtos;
    }
}
