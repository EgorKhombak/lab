package com.bsuir.lab.services;

import com.bsuir.lab.persistence.entity.Region;

import java.util.List;

public interface RegionService {

    Region create(Region region);
    Region findById(Long id);
    void deleteById(Long id);
    Region update(Region region);
    List<Region> getAllRegions();
}
