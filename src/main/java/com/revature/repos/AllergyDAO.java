package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Allergy;

public interface AllergyDAO extends JpaRepository<Allergy, Integer> {

}
