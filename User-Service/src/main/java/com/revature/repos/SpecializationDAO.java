package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Specialization;

public interface SpecializationDAO extends JpaRepository<Specialization, Integer>{

}
