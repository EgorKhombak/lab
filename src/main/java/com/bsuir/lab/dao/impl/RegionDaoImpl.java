package com.bsuir.lab.dao.impl;

import com.bsuir.lab.dao.RegionDao;
import com.bsuir.lab.persistence.entity.Region;
import com.bsuir.lab.utils.Querys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class RegionDaoImpl implements RegionDao {

    private EntityManager entityManager;

    @Autowired
    public RegionDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Region create(Region region) {
        entityManager.persist(region);
        return region;
    }

    @Override
    public Region findById(Long id) {
        return entityManager.find(Region.class, id);
    }

    @Override
    public void deleteById(Long id) {
        Region region = entityManager.getReference(Region.class, id);
        entityManager.remove(region);
    }

    @Override
    public Region update(Region region) {
        entityManager.merge(region);
        return region;
    }

    @Override
    public List<Region> getAllRegions() {
        return entityManager.createQuery(Querys.GET_ALL_REGIONS.getQuery(), Region.class).getResultList();
    }
}
