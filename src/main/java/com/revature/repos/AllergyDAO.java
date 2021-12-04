package com.revature.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.revature.models.Allergy;
import com.revature.models.Sex;

@Repository
public interface AllergyDAO extends JpaRepository<Allergy, Integer>{

	Optional<Allergy> findByAllergy(String name);
}
