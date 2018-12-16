package com.bsuir.lab.dao;


import com.bsuir.lab.persistence.entity.Users;

public interface UserDao {
	Users save(Users users);

	Users findByName(String name);
}
