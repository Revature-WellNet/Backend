package com.revature.patientservice.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.patientservice.model.Sex;

@Repository
public interface SexDAO extends JpaRepository<Sex, Integer>{
	
	Optional<Sex> findBySex(String name);
	
}
