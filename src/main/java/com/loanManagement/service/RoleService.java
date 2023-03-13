package com.loanManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loanManagement.dao.RoleDao;
import com.loanManagement.entity.Role;

@Service
public class RoleService {
	@Autowired
	private RoleDao roleDao;

	public Role createNewRole(Role role) {
		return roleDao.save(role);
	}
}
