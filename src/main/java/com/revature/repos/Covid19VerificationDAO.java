package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Area;
import com.revature.models.Covid19Verification;

@Repository
public interface Covid19VerificationDAO extends JpaRepository<Covid19Verification, Integer> {

	
	
}
