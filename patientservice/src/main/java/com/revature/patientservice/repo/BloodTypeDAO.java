package com.revature.patientservice.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.patientservice.model.BloodType;


@Repository
public interface BloodTypeDAO extends JpaRepository<BloodType, Integer>{

	Optional<BloodType> findByType(String name);

}
