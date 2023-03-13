package com.loanManagement.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.loanManagement.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, String> {

}

