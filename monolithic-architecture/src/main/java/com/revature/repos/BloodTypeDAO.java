package com.revature.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.BloodType;


@Repository
public interface BloodTypeDAO extends JpaRepository<BloodType, Integer>{

	Optional<BloodType> findByType(String name);

}
