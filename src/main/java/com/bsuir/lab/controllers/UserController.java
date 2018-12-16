package com.bsuir.lab.controllers;


import com.bsuir.lab.persistence.entity.Users;
import com.bsuir.lab.services.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.ServletException;
import java.util.Date;

@Controller
@RequestMapping("api/user")
public class UserController {

	private UserService userService;

	@Inject
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@ResponseBody
	@PostMapping(value = "/register")
	public Users registerUser(@RequestBody Users users) {
		return userService.save(users);
	}

	@ResponseBody
	@PostMapping(value = "/login")
	public String login(@RequestBody Users login) throws ServletException {

		String jwtToken = "";

		if (login.getName() == null || login.getPassword() == null) {
			throw new ServletException("Please fill in username and password");
		}

		String name = login.getName();
		String password = login.getPassword();

		Users users = userService.findByName(name);

		if (users == null) {
			throw new ServletException("Users name not found.");
		}

		String pwd = users.getPassword();

		if (!password.equals(pwd)) {
			throw new ServletException("Invalid login. Please check your name and password.");
		}

		jwtToken = Jwts.builder().setSubject(name).claim("roles", "users").setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "secretkey").compact();

		return jwtToken;
	}
}
