package com.bsuir.lab.services.impl;

import com.bsuir.lab.dao.UserDao;
import com.bsuir.lab.persistence.entity.Users;
import com.bsuir.lab.services.UserService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	@Inject
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	public Users save(Users users) {
		return userDao.save(users);
	}

	public Users findByName(String name) {
		return userDao.findByName(name);
	}
}
