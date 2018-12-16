package com.bsuir.lab.services;

import com.bsuir.lab.persistence.entity.Users;

public interface UserService {
	Users save(Users users);

	Users findByName(String name);

}
