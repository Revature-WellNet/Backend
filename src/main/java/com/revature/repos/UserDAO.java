package com.revature.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.User;

public interface UserDAO extends JpaRepository<User, Integer>{
	// TODO String?
	public Optional<User> findByUserId(String id);
	

}
