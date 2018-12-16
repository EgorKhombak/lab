package com.bsuir.lab.services.impl;

import com.bsuir.lab.dao.RegionDao;
import com.bsuir.lab.persistence.entity.Region;
import com.bsuir.lab.services.RegionService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    private RegionDao regionDao;

    @Inject
    public RegionServiceImpl(RegionDao regionDao) {
        this.regionDao = regionDao;
    }

    @Override
    public Region create(Region region) {
        return regionDao.create(region);
    }

    @Override
    public Region findById(Long id) {
        return regionDao.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        regionDao.deleteById(id);
    }

    @Override
    public Region update(Region region) {
        return regionDao.update(region);
    }

    @Override
    public List<Region> getAllRegions() {
        return regionDao.getAllRegions();
    }
}
