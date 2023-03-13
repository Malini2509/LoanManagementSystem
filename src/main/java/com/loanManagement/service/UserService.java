package com.loanManagement.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.loanManagement.dao.RoleDao;
import com.loanManagement.dao.UserDao;
import com.loanManagement.entity.Role;
import com.loanManagement.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public User registerNewUser(User user) {
		Role role = roleDao.findById("User").get();
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		user.setRole(roles);
		user.setPassword(getEncodedPassword(user.getPassword()));

		return userDao.save(user);

	}

	public void initRolesAndUser() {
		Role adminRole = new Role();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin of the application");
		roleDao.save(adminRole);
		Role userRole = new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("User of the application");
		roleDao.save(userRole);

		User adminUser = new User();
		adminUser.setUserName("Admin123");
		adminUser.setUserFirstName("Admin");
		adminUser.setUserLastName("admin");
		adminUser.setPassword(getEncodedPassword("Admin@12345"));
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setRole(adminRoles);
		userDao.save(adminUser);

//		User user = new User();
//		user.setUserName("User123");
//		user.setUserFirstName("User");
//		user.setUserLastName("User");
//		user.setPassword(getEncodedPassword("@User12345"));
//		Set<Role> userRoles = new HashSet<>();
//		userRoles.add(userRole);
//		user.setRole(userRoles);
//		userDao.save(user);

	}

	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}
}
