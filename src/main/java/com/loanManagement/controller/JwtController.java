package com.loanManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loanManagement.entity.JwtRequest;
import com.loanManagement.entity.JwtResponse;
import com.loanManagement.service.JwtService;

@CrossOrigin
@RestController
public class JwtController {
	@Autowired
	private JwtService jwtService;

	@PostMapping({ "/authenticate" })
	public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		return jwtService.createJwtToken(jwtRequest);
	}
}
