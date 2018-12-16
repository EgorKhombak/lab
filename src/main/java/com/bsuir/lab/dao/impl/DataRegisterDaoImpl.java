package com.bsuir.lab.dao.impl;

import com.bsuir.lab.dao.DataRegisterDao;
import com.bsuir.lab.persistence.entity.DataRegister;
import com.bsuir.lab.utils.Querys;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DataRegisterDaoImpl implements DataRegisterDao {

    private final EntityManager entityManager;

    @Inject
    public DataRegisterDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public DataRegister create(DataRegister dataRegister) {
        entityManager.persist(dataRegister);
        return dataRegister;
    }

    @Override
    public DataRegister findBuId(Long id) {
        return entityManager.find(DataRegister.class, id);
    }

    @Override
    public void deleteById(Long id) {
        DataRegister dataRegister = entityManager.getReference(DataRegister.class, id);
        entityManager.remove(dataRegister);
    }

    @Override
    public DataRegister update(DataRegister dataRegister) {
        entityManager.merge(dataRegister);
        return dataRegister;
    }

    @Override
    public List<DataRegister> getAllDataRegisters() {
        return entityManager.createQuery(Querys.GET_ALL_DATA_REGISTERS.getQuery(), DataRegister.class).getResultList();
    }
}
