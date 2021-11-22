package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.BloodType;


@Repository
public interface BloodTypeDAO extends JpaRepository<BloodType, Integer>{

}
