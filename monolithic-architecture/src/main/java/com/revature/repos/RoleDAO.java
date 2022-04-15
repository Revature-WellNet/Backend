package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Role;

public interface RoleDAO extends JpaRepository<Role, Integer>{

}
