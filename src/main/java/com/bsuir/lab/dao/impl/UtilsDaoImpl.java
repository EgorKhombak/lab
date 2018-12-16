package com.bsuir.lab.dao.impl;

import com.bsuir.lab.dao.UtilsDao;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UtilsDaoImpl implements UtilsDao {

    private EntityManager entityManager;

    @Inject
    public UtilsDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<JsonNode> getAllInfo() {
        entityManager.createQuery("select u")
    }
}
