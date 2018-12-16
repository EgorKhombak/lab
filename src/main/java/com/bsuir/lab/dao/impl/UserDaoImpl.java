package com.bsuir.lab.dao.impl;

import com.bsuir.lab.dao.UserDao;
import com.bsuir.lab.persistence.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Users save(Users users) {
        entityManager.persist(users);
        return users;
    }

    @Override
    public Users findByName(String name) {
        TypedQuery<Users> query = entityManager.createQuery("select u from Users u where u.name = :name", Users.class);
        return query.setParameter("name", name).getSingleResult();
    }
}
