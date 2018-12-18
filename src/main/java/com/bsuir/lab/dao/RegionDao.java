package com.bsuir.lab.dao;

import com.bsuir.lab.persistence.entity.Region;

import java.util.List;

public interface RegionDao {

    Region create(Region region);
    Region findById(Long id);
    void deleteById(Long id);
    Region update(Region region);
    List<Region> getAllRegions();
    Region findByName(String name);
}
