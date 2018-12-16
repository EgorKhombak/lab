package com.bsuir.lab.controllers;

import com.bsuir.lab.persistence.entity.Users;
import com.bsuir.lab.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure")
public class SecureController {

	@Autowired
	private UserService userService;

	@RequestMapping("/user/users")
	public String loginSuccess() {
		return "Login Successful!";
	}

	@RequestMapping(value = "/user/email", method = RequestMethod.POST)
	public Users findByEmail(@RequestBody String name) {
		return userService.findByName(name);
	}

	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public Users updateUser(@RequestBody Users users) {
		return userService.save(users);
	}
}
