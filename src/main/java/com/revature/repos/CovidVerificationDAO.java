package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Covid19Verifcation;

@Repository
public interface CovidVerificationDAO extends JpaRepository<Covid19Verifcation, Integer> {

}
