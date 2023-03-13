package com.loanManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loanManagement.entity.User;
import com.loanManagement.service.UserService;

import jakarta.annotation.PostConstruct;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@PostConstruct
	public void initRolesAndUsers() {
		userService.initRolesAndUser();
	}

	@PostMapping({ "/registerNewUser" })
	public User registerNewUser(@RequestBody User user) {
		return userService.registerNewUser(user);

	}

	@GetMapping({ "/forAdmin" })
	@PreAuthorize("hasRole('Admin')")
	public String forAdmin() {
		return "This url is accessible for admin";
	}

	@GetMapping({ "/forUsers" })
	@PreAuthorize("hasRole('User')")
	public String forUser() {
		return "This url is accessible for newly created record";
	}
}
